package com.crud.exampleapp.Model.Beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@RedisHash("books")
public class Book {

    public Book(String title, String genre, Set<String> authors) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
    }

    @Id
    private String title;
    private String genre;

    public Set<String> getAuthors() {
        return authors;
    }

    private Set<String> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addAuthor(String author) {
        authors.add(author);
    }

    public void removeAuthor(String author) {
        authors.remove(author);
    }

}
