package com.proofpoint.service;

import com.proofpoint.config.BlockChainConfiguration;
import com.proofpoint.document.BlockchainConfig;
import com.proofpoint.document.SmartContract;
import com.proofpoint.repository.BlockchainConfigRepository;
import com.proofpoint.repository.SmartContractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.*;
import org.web3j.model.NewsContract;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.Objects;

import static com.proofpoint.config.BlockChainConfiguration.GAS_LIMIT;

@Service
@Slf4j
public class BlockchainConfigService {

    private Web3j web3jClient;
    private ContractGasProvider provider;
    private final BlockChainConfiguration configuration;
    private final BlockchainConfigRepository blockchainConfigRepository;
    private SmartContractRepository smartContractRepository;
    private NewsContract contract;

    public BlockchainConfigService(BlockChainConfiguration configuration, BlockchainConfigRepository blockchainConfigRepository, SmartContractRepository smartContractRepository) {
        this.configuration = configuration;
        this.blockchainConfigRepository = blockchainConfigRepository;
        this.smartContractRepository = smartContractRepository;
        this.web3jClient = Web3j.build(new HttpService(this.configuration.getUrl()));
        provider = new StaticGasProvider(BigInteger.ZERO, BigInteger.valueOf(GAS_LIMIT));
    }

    public Credentials createNewCredentials(String password) throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        return loadCredentialsFromPK(ecKeyPair.getPrivateKey(), ecKeyPair.getPublicKey(), password);
    }

    private Credentials loadCredentialsFromPK(BigInteger privateKey, BigInteger publicKey, String password) {
        try {
            ECKeyPair ecKeyPair = new ECKeyPair(privateKey, publicKey);
            WalletFile light = Wallet.createLight(password, ecKeyPair);
            return Credentials.create(Wallet.decrypt(password, light));
        } catch (Exception e) {
            log.error("Credentials cloud not creted,please check, public key, private key and credentials password!!!");
            System.exit(1);
        }
        return null;
    }

    public String getExplorerUrl(String transactionHash) {
        return configuration.getExplorerUrl() + "/#section=explorer&widgetId=txn-detail&data=%22" + transactionHash+"%22";
    }

    public NewsContract getContract() {
        if (Objects.isNull(this.contract)) {
            this.contract = getNewsContract();
        }
        return this.contract;
    }

    private NewsContract getNewsContract() {
        BlockchainConfig blockChainConfig = blockchainConfigRepository.findByIsActivated(Boolean.TRUE).orElseThrow(() -> new RuntimeException("Blockchain configuration not found"));
        Credentials credentials = loadCredentialsFromPK(new BigInteger(blockChainConfig.getBpk()), new BigInteger(blockChainConfig.getBpp()), "");

        SmartContract contract = smartContractRepository.findByContractNameAndIsActivated("NewsContract", true).orElseThrow(() -> new RuntimeException("Declaration contract not found"));
        TransactionManager transactionManager = new RawTransactionManager(web3jClient, credentials, configuration.getChainId());
        return NewsContract.load(contract.getContractAddress(), web3jClient, transactionManager, provider);
    }
}
