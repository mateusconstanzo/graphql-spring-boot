package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.model.Author;
import com.example.model.Post;
import com.example.service.AuthorService;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final AuthorService authorService;
    private final PostService postService;

    @Autowired
    public Mutation(AuthorService authorService, PostService postService) {
        this.authorService = authorService;
        this.postService = postService;
    }

    public Post savePost(Integer authorId, String title, String text, String category) {
        return postService.save(authorId, title, text, category);
    }

    public Author saveAuthor(String firstName, String lastName) {
        return authorService.save(firstName, lastName);
    }

}