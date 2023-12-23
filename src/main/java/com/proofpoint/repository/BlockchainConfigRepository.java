package com.proofpoint.repository;

import com.proofpoint.document.BlockchainConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BlockchainConfigRepository extends MongoRepository<BlockchainConfig, String> {

    Optional<BlockchainConfig> findByIsActivated(Boolean isActivated);
}
