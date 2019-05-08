package com.springclouddataflow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springclouddataflow.entity.Data;

public interface SinkRepository extends MongoRepository<Data, String>{

}
