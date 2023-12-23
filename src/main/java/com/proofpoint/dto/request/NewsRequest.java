package com.proofpoint.dto.request;

import com.proofpoint.enums.DocumentType;
import com.proofpoint.enums.DocumentTypeCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsRequest {

    private DocumentType type;
    private DocumentTypeCategory category;
    private String title;
    private String description;
    private String content;
    private String author;
}
