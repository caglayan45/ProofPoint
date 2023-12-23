package com.proofpoint.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsResponse {

    private String transactionHash;
    private String blockNumber;
    private String contractAddress;
    private String blockchainId;
    private String explorerUrl;
    private Object chainData;
}

