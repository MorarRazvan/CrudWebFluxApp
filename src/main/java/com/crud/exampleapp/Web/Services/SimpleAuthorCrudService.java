package com.crud.exampleapp.Web.Services;

import com.crud.exampleapp.Model.Beans.Author;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface SimpleAuthorCrudService {

    Mono<Author> create(Author author);

    Mono<Author> retrieve(String id);

    Mono<Author> update(Author author);

    Mono<String> delete(String author);
}
