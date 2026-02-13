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
@RedisHash("authors")
public class Author {
    @Id
    private String id;
    @NotBlank
    private String name;
    private Set<String> books = new HashSet<>();
}