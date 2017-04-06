package com.sample.rxjs.repositories;

import com.sample.rxjs.models.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AppRepository extends MongoRepository<Application, Long> {

    @Query("{ 'author' : { '$regex': '^.*?0.*', '$options': 'si' } }")
    List<Application> findByAuthor(String authorRegex);

}
