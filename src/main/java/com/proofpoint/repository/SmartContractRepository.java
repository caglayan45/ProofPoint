package com.proofpoint.repository;

import com.proofpoint.document.SmartContract;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SmartContractRepository extends MongoRepository<SmartContract, String> {

    Optional<SmartContract> findByContractNameAndIsActivated(String name, Boolean isActivated);
}
