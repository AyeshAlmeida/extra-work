package com.sample.rxjs.repositories;

import com.sample.rxjs.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,Long> {

    @Query("{ 'author' : { '$regex': '^.*?0.*', '$options': 'si' } }")
    List<Book> findByAuthor(String authorRegex);

}
