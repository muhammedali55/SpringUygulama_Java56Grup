package com.vektorel.services;

import com.vektorel.respository.MongoMusteriRepoitory;
import com.vektorel.respository.entity.MongoMusteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoMusteriService {

    @Autowired
    MongoMusteriRepoitory repoitory;

    public void save(MongoMusteri musteri){
        repoitory.save(musteri);
    }
    @Cacheable(cacheNames = "mongodbGetAll")
    public List<MongoMusteri> getAll(){
        return repoitory.findAll();
    }
}
