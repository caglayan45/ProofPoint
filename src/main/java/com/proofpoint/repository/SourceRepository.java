package com.proofpoint.repository;

import com.proofpoint.document.News;
import com.proofpoint.document.Source;
import com.proofpoint.enums.DocumentType;
import com.proofpoint.enums.DocumentTypeCategory;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SourceRepository extends MongoRepository<Source, String> {

    @NotNull
    Optional<Source> findById(@NotNull String id);
}
