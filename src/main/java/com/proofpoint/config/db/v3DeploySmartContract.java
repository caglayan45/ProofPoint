package com.proofpoint.config.db;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.proofpoint.config.BlockChainConfiguration;
import com.proofpoint.document.BlockchainConfig;
import com.proofpoint.document.SmartContract;
import com.proofpoint.service.BlockchainConfigService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.web3j.crypto.Credentials;
import org.web3j.model.NewsContract;
import org.web3j.model.NewsDataStorage;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static com.proofpoint.config.BlockChainConfiguration.GAS_LIMIT;

@ChangeLog(order = "001")
public class v3DeploySmartContract {

    @ChangeSet(order = "001", id = "deploySmartContract", author = "mongock")
    public void deploySmartContract(BlockChainConfiguration blockChainConfiguration, BlockchainConfigService blockchainConfigService, MongoTemplate mongoTemplate) throws Exception {
        Credentials blockChainKey = blockchainConfigService.createNewCredentials("");

        String bbp = blockChainKey.getEcKeyPair().getPublicKey().toString();

        String bpk = blockChainKey.getEcKeyPair().getPrivateKey().toString();
        BlockchainConfig blockchainConfigDocument = new BlockchainConfig(null, bbp, bpk,Boolean.TRUE);

        Web3j web3j = Web3j.build(new HttpService(blockChainConfiguration.getUrl()));
        StaticGasProvider provider = new StaticGasProvider(BigInteger.ZERO, BigInteger.valueOf(GAS_LIMIT));

        TransactionManager transactionManager = new RawTransactionManager(web3j, blockChainKey, blockChainConfiguration.getChainId());

        NewsDataStorage declarationDataStorage = NewsDataStorage.deploy(web3j, transactionManager, provider).send();
        NewsContract declarationContract = NewsContract.deploy(web3j, transactionManager, provider, declarationDataStorage.getContractAddress()).send();

        declarationDataStorage.allowAccess(declarationContract.getContractAddress()).send();

        mongoTemplate.save(blockchainConfigDocument);
        mongoTemplate.save(SmartContract.builder().contractAddress(declarationDataStorage.getContractAddress()).contractName("NewsDataStorage").deployDate(LocalDateTime.now()).isActivated(Boolean.TRUE).build());
        mongoTemplate.save(SmartContract.builder().contractAddress(declarationContract.getContractAddress()).contractName("NewsContract").deployDate(LocalDateTime.now()).isActivated(Boolean.TRUE).build());
    }
}

