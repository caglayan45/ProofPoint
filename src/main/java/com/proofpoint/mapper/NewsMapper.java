package com.proofpoint.mapper;

import com.proofpoint.document.News;
import com.proofpoint.dto.request.NewsRequest;
import com.proofpoint.dto.response.NewsResponse;
import com.proofpoint.dto.response.PendingNewsResponse;
import com.proofpoint.enums.Status;
import com.proofpoint.service.BlockchainConfigService;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {

    private BlockchainConfigService blockchainConfigService;

    public NewsMapper(BlockchainConfigService blockchainConfigService) {
        this.blockchainConfigService = blockchainConfigService;
    }

    public NewsResponse toResponse(News news, Object chainData) {
        return NewsResponse.builder()
                .blockchainId(news.getTransaction().getBlockchainId())
                .blockNumber(news.getTransaction().getBlockNumber())
                .chainData(chainData)
                .contractAddress(news.getTransaction().getContractAddress())
                .transactionHash(news.getTransaction().getTransactionHash())
                .explorerUrl(blockchainConfigService.getExplorerUrl(news.getTransaction().getTransactionHash()))
                .build();
    }

    public News toDocument(NewsRequest request) {
        return News.builder()
                .type(request.getType())
                .title(request.getTitle())
                .content(request.getContent())
                .description(request.getDescription())
                .author(request.getAuthor())
                .category(request.getCategory())
                .status(Status.PENDING)
                .build();
    }

    public PendingNewsResponse toPendingNewsResponse(News news) {
        return PendingNewsResponse.builder()
                .id(news.getId())
                .type(news.getType())
                .title(news.getTitle())
                .content(news.getContent())
                .description(news.getDescription())
                .author(news.getAuthor())
                .category(news.getCategory())
                .status(news.getStatus())
                .build();
    }
}
