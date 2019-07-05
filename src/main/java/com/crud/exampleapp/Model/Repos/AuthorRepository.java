package com.crud.exampleapp.Model.Repos;


import com.crud.exampleapp.Model.Beans.Author;
import reactor.core.publisher.Mono;



public interface AuthorRepository {

    Mono<Author> save(Author author);

    Mono<Author> findById(String id);

    Mono<String> delete(String id);
}
