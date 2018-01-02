package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.model.Author;
import com.example.model.Post;
import com.example.service.AuthorService;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class Query implements GraphQLQueryResolver {

    private final AuthorService authorService;
    private final PostService postService;

    @Autowired
    public Query(AuthorService authorService, PostService postService) {
        this.authorService = authorService;
        this.postService = postService;
    }

    public List<Post> posts() {
        return postService.findAll();
    }

    public List<Author> authors() {
        return authorService.findAll();
    }

}