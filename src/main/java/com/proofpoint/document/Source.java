package com.proofpoint.document;

import com.proofpoint.enums.DocumentType;
import com.proofpoint.enums.DocumentTypeCategory;
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
@Document(collection = "source")
public class Source implements Serializable {

    @Id
    private String id;

    @Field
    private String newsId;

    @Field
    private String name;

    @Field
    private String url;
}
