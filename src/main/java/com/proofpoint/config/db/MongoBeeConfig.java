package com.proofpoint.config.db;

import com.github.cloudyrock.mongock.SpringBootMongock;
import com.github.cloudyrock.mongock.SpringBootMongockBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoBeeConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String url;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public SpringBootMongock mongobee(ApplicationContext applicationContext, Environment environment) {
            return new SpringBootMongockBuilder(mongoClient(), getDatabaseName(), "com.proofpoint.config.db")
                .setSpringEnvironment(environment)
                .setApplicationContext(applicationContext)
                .setEnabled(true)
                .setChangeLogCollectionName("changeLog")
                .build();
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(url);
    }
}
