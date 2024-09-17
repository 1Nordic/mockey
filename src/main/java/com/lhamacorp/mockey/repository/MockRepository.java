package com.lhamacorp.mockey.repository;

import com.lhamacorp.mockey.model.Mockey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MockRepository extends MongoRepository<Mockey, String> {
}
