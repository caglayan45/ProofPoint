package com.proofpoint.dto.response;

import com.proofpoint.enums.DocumentType;
import com.proofpoint.enums.DocumentTypeCategory;
import com.proofpoint.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PendingNewsResponse {

    private String id;
    private DocumentType type;
    private DocumentTypeCategory category;
    private String title;
    private String description;
    private String content;
    private String author;
    private Status status;
}
