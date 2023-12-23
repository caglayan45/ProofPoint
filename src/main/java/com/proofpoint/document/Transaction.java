package com.proofpoint.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Transaction {

    private String transactionHash;
    private String blockNumber;
    private String contractAddress;
    private String blockchainId;
}
