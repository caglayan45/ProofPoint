package com.proofpoint.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OpenApiConfig {

    public static final String CHAIN_API_KEY = "CHAIN-API-KEY";
    public static final String AUTHORIZATION = "Authorization";

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${io.document.company.description:Create News in blockchain system}") String description,
            @Value("${io.document.company.version:v1}") String version,
            @Value("${io.document.company.title:ProofPoint Blockchain System}") String title,
            @Value("${io.document.company.contact:Çağlayan Sancaktar}") String contactName,
            @Value("${io.document.company.email:caglayansancaktar@gmail.com}") String email,
            @Value("${io.document.company.licence:}") String licenseName,
            @Value("${io.document.company.url:}") String url
    ) {

        OpenAPI openApi = new OpenAPI().info(new Info().title(title).description(description).version(version)
                        .contact(new Contact().name(contactName).email(email))
                        .license(new License().name(licenseName).url(url)));

        log.info(openApi.toString());
        return openApi;
    }

    public SecurityScheme apiKeySecuritySchema() {
        return new SecurityScheme()
                .name(CHAIN_API_KEY) //
                .description("Please contact with administrator to get api key")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.APIKEY);
    }


}