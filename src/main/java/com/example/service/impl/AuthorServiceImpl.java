package com.example.service.impl;

import com.example.model.Author;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import com.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, PostRepository postRepository) {
        this.authorRepository = authorRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    @Override
    public Author save(String firstName, String lastName) {

        return authorRepository.save(new Author(firstName, lastName));

    }

    @Transactional(readOnly = true)
    @Override
    public Author findById(Integer id) {

        Author author = authorRepository.findOne(id);

        if (author == null) {
            throw new IllegalArgumentException("No author found");
        }

        return author;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
