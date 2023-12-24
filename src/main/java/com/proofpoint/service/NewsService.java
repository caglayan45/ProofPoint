package com.proofpoint.service;

import com.proofpoint.document.News;
import com.proofpoint.document.Transaction;
import com.proofpoint.dto.request.NewsRequest;
import com.proofpoint.dto.response.NewsResponse;
import com.proofpoint.mapper.NewsMapper;
import com.proofpoint.repository.NewsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.web3j.abi.EventValues;
import org.web3j.abi.datatypes.Type;
import org.web3j.model.NewsContract;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final BlockchainConfigService blockchainConfigService;
    private final NewsMapper newsMapper;

    public NewsResponse getNews(String id) {
        NewsContract contract = blockchainConfigService.getContract();

        Optional<News> optionalNews = Optional.ofNullable(newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction can not found by object id:" + id)));
        News news = optionalNews.orElse(null);
        return getNewsResponse(news, contract);
    }

    public NewsResponse getNewsByTxId(String txId) {
        NewsContract contract = blockchainConfigService.getContract();

        Optional<News> optionalNews = Optional.ofNullable(newsRepository.findByTransactionTransactionHash(txId)
                .orElseThrow(() -> new RuntimeException("Transaction can not found by transaction id:" + txId)));
        News news = optionalNews.orElse(null);
        return getNewsResponse(news, contract);
    }

    @Nullable
    private NewsResponse getNewsResponse(News news, NewsContract contract) {
        if (Objects.isNull(news)) {
            return null;
        }

        try {
            Tuple8<BigInteger, String, String, String, String, String, String, String> blockchainNews = contract.getNews(new BigInteger(news.getTransaction().getBlockchainId())).send();
            return newsMapper.toResponse(news, blockchainNews);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NewsResponse> getNews() {
        NewsContract contract = blockchainConfigService.getContract();
        List<News> newsList = newsRepository.findAll();
        return newsList.stream().map(news -> getNewsResponse(news, contract)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public NewsResponse createNews(NewsRequest request) {
        NewsContract contract = blockchainConfigService.getContract();

        TransactionReceipt result = null;
        News savedNews = null;
        try {
            News newsDocument = newsMapper.toDocument(request);
            savedNews = newsRepository.save(newsDocument);
            result = contract.createNewsWithData(savedNews.getId(),
                    "PROOFPOINT",
                    savedNews.getType().name(),
                    savedNews.getCategory().name(),
                    savedNews.getTitle(),
                    savedNews.getDescription(),
                    savedNews.getContent(),
                    savedNews.getAuthor()).send();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }

        EventValues eventValues = NewsContract.staticExtractEventParameters(NewsContract.CREATENEWSEVENT_EVENT, result.getLogs().get(0));
        log.debug("Chain eventValues {}", eventValues);

        List<? extends Type> indexedValues = eventValues.getIndexedValues();
        log.debug("chain indexedValues {}", indexedValues);

        BigInteger certificateIndex = new BigInteger(indexedValues.get(1).getValue().toString());

        Transaction transaction = Transaction.builder()
                .contractAddress(contract.getContractAddress())
                .transactionHash(result.getTransactionHash())
                .blockchainId(certificateIndex.toString())
                .blockNumber(result.getBlockNumber().toString())
                .build();

        savedNews.setTransaction(transaction);
        newsRepository.save(savedNews);

        return NewsResponse.builder()
                .transactionHash(transaction.getTransactionHash())
                .blockNumber(transaction.getBlockNumber())
                .explorerUrl(blockchainConfigService.getExplorerUrl(transaction.getTransactionHash()))
                .blockchainId(transaction.getBlockchainId())
                .contractAddress(transaction.getContractAddress())
                .build();
    }
}
