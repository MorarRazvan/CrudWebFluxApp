package com.crud.exampleapp.Model.Repos;


import com.crud.exampleapp.Model.Beans.Book;
import reactor.core.publisher.Mono;


public interface BookRepository {

    Mono<Book> save(Book book);

    Mono<Book> findById(String id);

    Mono<String> delete(String id);
}
