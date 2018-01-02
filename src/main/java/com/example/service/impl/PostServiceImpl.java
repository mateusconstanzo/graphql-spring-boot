package com.example.service.impl;

import com.example.model.Author;
import com.example.model.Post;
import com.example.repository.PostRepository;
import com.example.service.AuthorService;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final AuthorService authorService;
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(AuthorService authorService, PostRepository postRepository) {
        this.authorService = authorService;
        this.postRepository = postRepository;
    }

    @Transactional
    @Override
    public Post save(Integer authorId, String title, String text, String category) {

        Author author = authorService.findById(authorId);

        Post post = new Post();
        post.setText(text);
        post.setTitle(title);
        post.setCategory(category);

        post.setAuthorId(author.getId());
        post.setAuthor(author);

        return postRepository.save(post);

    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> findByAuthor(Author author) {
        return postRepository.findByAuthor(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
