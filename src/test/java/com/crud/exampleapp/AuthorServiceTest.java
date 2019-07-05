package com.crud.exampleapp;

import com.crud.exampleapp.Model.Beans.Author;
import com.crud.exampleapp.Model.Beans.Book;
import com.crud.exampleapp.Model.Repos.AuthorRepository;
import com.crud.exampleapp.Model.Repos.BookRepository;
import com.crud.exampleapp.Web.Services.Impl.SimpleAuthorCrudServiceImpl;
import com.crud.exampleapp.Web.Services.SimpleAuthorCrudService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {

    private AuthorRepository authorRepository = Mockito.mock(AuthorRepository.class);
    private BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private SimpleAuthorCrudService service = new SimpleAuthorCrudServiceImpl(authorRepository, bookRepository);

    @Before
    public void setup() {
        when(authorRepository.save(any()))
                .thenAnswer((Answer<Mono<Author>>) invocationOnMock -> Mono.just((Author) invocationOnMock.getArguments()[0]));
        when(authorRepository.save(any()))
                .thenAnswer((Answer<Mono<Book>>) invocationOnMock -> Mono.just((Book) invocationOnMock.getArguments()[0]));
    }

    @Test
    public void shortensLink() {
        Set<String> books = new HashSet<>();
        books.add("Book1");
        books.add("book2");
        Author author = new Author("1", "TestName1", books);
        StepVerifier.create(service.create(author))
                .expectNextMatches(result -> result != null)
                .expectComplete()
                .verify();
    }

}
