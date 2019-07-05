package com.crud.exampleapp.Model.Repos.Impl;

import com.crud.exampleapp.Model.Beans.Author;
import com.crud.exampleapp.Model.Repos.AuthorRepository;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private final ReactiveRedisOperations<String, Author> operations;

    public AuthorRepositoryImpl(ReactiveRedisOperations<String, Author> operations) {
        this.operations = operations;
    }

    @Override
    public Mono<Author> save(Author author) {
        return operations.opsForValue().set(author.getId(), author).map(__ -> author);
    }

    @Override
    public Mono<Author> findById(String id) {
        return operations.opsForValue().get(id);
    }

    @Override
    public Mono<String> delete(String id) {
        return operations.opsForValue().delete(id).map(__ -> id);
    }


}
