package com.example.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.model.Author;
import com.example.model.Post;
import com.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<Post> {

    private final AuthorService authorService;

    @Autowired
    public PostResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Author getAuthor(Post post) {
        return authorService.findById(post.getAuthorId());
    }

}
