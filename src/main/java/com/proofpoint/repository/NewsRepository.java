package com.proofpoint.repository;

import com.proofpoint.document.News;
import com.proofpoint.enums.DocumentType;
import com.proofpoint.enums.DocumentTypeCategory;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends MongoRepository<News, String> {

    @NotNull
    Optional<News> findById(@NotNull String id);

    Optional<News> findByTransactionTransactionHash(String txId);

    Optional<News> findByTransactionBlockchainId(String blockchainId);

    Optional<News> findByType(DocumentType type);

    List<News> findByCategory(DocumentTypeCategory category);
}
