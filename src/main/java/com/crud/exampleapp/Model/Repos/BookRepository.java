package com.crud.exampleapp.Model.Repos;

import com.crud.exampleapp.Model.Beans.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveCrudRepository<Book, String> {
    Flux<Book> findByGenreContaining(String genre);
}