package com.example.service;

import com.example.model.Author;
import com.example.model.Post;

import java.util.List;

public interface PostService {

    Post save(Integer authorId, String title, String text, String category);

    List<Post> findByAuthor(Author author);

    List<Post> findAll();

}
