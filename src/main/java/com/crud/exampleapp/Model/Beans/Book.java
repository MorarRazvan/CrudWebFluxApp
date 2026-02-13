package com.crud.exampleapp.Model.Beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("books")
public class Book {
    @Id
    @NotBlank
    private String title;
    @NotBlank
    private String genre;
    private Set<String> authors = new HashSet<>();
}