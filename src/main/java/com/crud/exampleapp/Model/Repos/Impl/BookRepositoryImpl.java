package com.crud.exampleapp.Model.Repos.Impl;

import com.crud.exampleapp.Model.Beans.Book;
import com.crud.exampleapp.Model.Repos.BookRepository;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final ReactiveRedisOperations<String, Book> operations;

    public BookRepositoryImpl(ReactiveRedisOperations<String, Book> operations) {
        this.operations = operations;
    }


    @Override
    public Mono<Book> save(Book book) {
        return operations.opsForValue().set(book.getTitle(), book).map(__ -> book);
    }

    @Override
    public Mono<Book> findById(String title) {
        return operations.opsForValue().get(title);
    }

    @Override
    public Mono<String> delete(String title) {
        return operations.opsForValue().delete(title).map(__ -> title);
    }
}
