package com.crud.exampleapp;

import com.crud.exampleapp.Model.Beans.Author;
import com.crud.exampleapp.Model.Repos.AuthorRepository;
import com.crud.exampleapp.Web.Application;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Ignore //this test requires a docker running a redis image so it's disabled by default
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testSave() {
        Set<String> books = new HashSet<>();
        books.add("Book1");
        books.add("book2");
        Author author = new Author("1", "TestName1", books);
        StepVerifier.create(authorRepository.save(author)
                .flatMap(__ -> authorRepository.findById(author.getId())))
                .expectNext(author)
                .verifyComplete();
    }
}
