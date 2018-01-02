package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.model.Author;
import com.example.model.Post;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    private final PostService postService;

    @Autowired
    public AuthorResolver(PostService postService) {
        this.postService = postService;
    }

    public String getName(Author author) {
        return String.format("%s %s", author.getFirstName(), author.getLastName());
    }

    public List<Post> getPosts(Author author) {
        return postService.findByAuthor(author);
    }


}