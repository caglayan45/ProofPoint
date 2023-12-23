package com.proofpoint.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "blockchain_config")
public class BlockchainConfig implements Serializable {

    @Id
    private String id;

    @Field
    private String bpp;//public key

    @Field
    private String bpk;//private key

    @Field
    private Boolean isActivated;

}
