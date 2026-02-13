package com.crud.exampleapp.Model.Repos;

import com.crud.exampleapp.Model.Beans.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AuthorRepository extends ReactiveCrudRepository<Author, String> {
    Flux<Author> findByNameContaining(String name);
}