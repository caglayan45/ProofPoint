package com.proofpoint.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "smart_contract")
public class SmartContract implements Serializable {

    @Id
    private String id;

    @Field
    private String contractAddress;

    @Field
    private String contractName;

    @Field
    private LocalDateTime deployDate;

    @Field
    private Boolean isActivated;
}
