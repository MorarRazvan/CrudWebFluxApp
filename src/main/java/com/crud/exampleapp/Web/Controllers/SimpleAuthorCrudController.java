package com.crud.exampleapp.Web.Controllers;

import com.crud.exampleapp.Model.Beans.Author;
import com.crud.exampleapp.Web.Services.SimpleAuthorCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class SimpleAuthorCrudController {

    private final SimpleAuthorCrudService simpleAuthorCrudService;

    public SimpleAuthorCrudController(SimpleAuthorCrudService simpleAuthorCrudService) {
        this.simpleAuthorCrudService = simpleAuthorCrudService;
    }

    @GetMapping("/authors/id")
    public Mono<Author> retrieve(@RequestParam(name = "id") String id) {
        return simpleAuthorCrudService.retrieve(id);
    }

    @PostMapping("/authors")
    public Mono<Author> create(@RequestBody Author author) {
        return simpleAuthorCrudService.create(author);
    }

    @PutMapping("/authors")
    public Mono<Author> update(@RequestBody Author author) {
        return simpleAuthorCrudService.update(author);
    }

    @DeleteMapping("/authors/{id}")
    public Mono<String> delete(@RequestParam(name = "id") String id) {
        return simpleAuthorCrudService.delete(id);
    }

}



