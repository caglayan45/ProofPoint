package com.proofpoint.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "blockchain")
@Setter
@Getter
public class BlockChainConfiguration {

    public static final int GAS_LIMIT = 4712388;

    private String url;

    @Value("${blockchain.chainId:3434}")
    private Integer chainId;

    @Value("${blockchain.explorer-url:http://localhost:8999}")
    private String explorerUrl;

}
