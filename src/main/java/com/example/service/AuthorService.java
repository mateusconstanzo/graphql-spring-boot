package com.example.service;

import com.example.model.Author;

import java.util.List;

public interface AuthorService {

    Author save(String firstName, String lastName);

    Author findById(Integer id);

    List<Author> findAll();

}
