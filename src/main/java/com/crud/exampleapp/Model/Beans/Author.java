package com.crud.exampleapp.Model.Beans;

import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.Set;

@RedisHash("authros")
public class Author {

    private String name;

    public Set<String> getBooks() {
        return books;
    }

    private Set<String> books;
    private String id;

    public String getId() {
        return id;
    }

    public Author(String id, String name, Set<String> books) {
        this.name = name;
        this.books = books;
        this.id = id;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }


}
