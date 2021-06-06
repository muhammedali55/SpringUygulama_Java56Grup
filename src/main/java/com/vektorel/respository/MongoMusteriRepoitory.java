package com.vektorel.respository;

import com.vektorel.respository.entity.MongoMusteri;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoMusteriRepoitory extends MongoRepository<MongoMusteri,String> {
}
