package com.proofpoint.config.db;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.proofpoint.document.News;
import com.proofpoint.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Slf4j
@ChangeLog(order = "001")
public class addingStatus {

    private static final String STATUS = "status";

    @ChangeSet(order = "001", id = "addingStatus", author = "mongock")
    public void addingStatus(MongoTemplate mongoTemplate) {
        log.info("addingStatus:statuses adding...");
        final Query query = new Query().addCriteria(Criteria.where(STATUS).is(null));
        List<News> newsList = mongoTemplate.find(query, News.class);

        newsList.forEach(news -> {
            news.setStatus(Status.APPROVED);
            mongoTemplate.save(news);
        });
        log.info("addingStatus:statuses added.");
    }
}

