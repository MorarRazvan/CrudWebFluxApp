package com.crud.exampleapp.Web.Services.Impl;

import com.crud.exampleapp.Model.Beans.Author;
import com.crud.exampleapp.Model.Repos.AuthorRepository;
import com.crud.exampleapp.Model.Repos.BookRepository;
import com.crud.exampleapp.Web.Services.SimpleAuthorCrudService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SimpleAuthorCrudServiceImpl implements SimpleAuthorCrudService {


    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public SimpleAuthorCrudServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Mono<Author> create(Author author) {
        for (String id : author.getBooks()) {
            bookRepository.findById(id).flatMap(result -> {
                if (result != null) result.addAuthor(author.getId());
                return bookRepository.save(result);
            });
        }
        return authorRepository.save(author);
    }

    @Override
    public Mono<Author> retrieve(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public Mono<Author> update(Author author) {
        for (String id : author.getBooks()) {
            bookRepository.findById(id).flatMap(result -> {
                if (result != null) result.addAuthor(author.getId());
                return bookRepository.save(result);
            });
        }
        return authorRepository.save(author);
    }

    @Override
    public Mono<String> delete(String id) {
        return authorRepository.delete(id);
    }
}
