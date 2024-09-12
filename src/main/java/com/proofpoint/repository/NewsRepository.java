package com.proofpoint.repository;

import com.proofpoint.document.News;
import com.proofpoint.enums.DocumentTypeCategory;
import com.proofpoint.enums.Status;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends MongoRepository<News, String> {

    @NotNull
    Optional<News> findByIdAndTransactionIsNotNull(@NotNull String id);

    Optional<News> findByTransactionTransactionHash(String txId);

    List<News> findByCategoryAndStatus(DocumentTypeCategory category, Status status);

    List<News> findAllByStatus(Status status);
}
