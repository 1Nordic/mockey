package com.lhamacorp.mockey.repository;

import com.lhamacorp.mockey.model.Mockey;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.Instant;

import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@AllArgsConstructor
public class MockRepositoryCustomImpl implements MockRepositoryCustom {

    private final MongoTemplate template;

    public void updateLastAccessed(String id, Instant lastAccessed) {
        Criteria criteria = Criteria.where("id").is(id);
        Update update = new Update().set("lastAccessed", lastAccessed);
        template.updateFirst(query(criteria), update, Mockey.class);
    }

}
