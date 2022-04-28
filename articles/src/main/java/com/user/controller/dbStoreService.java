package com.user.controller;

import com.user.model.Articles;
import com.user.model.Comments;
import com.user.repository.ArticlesRepository;
import com.user.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class dbStoreService {

    @Autowired
    ArticlesRepository articlesRepository;

    @Autowired
    CommentsRepository commentsRepository;

    /*article store service*/ //TODO
    @GetMapping("/articles")
    public Collection<Articles> getFindAllArticles() {
        return articlesRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Optional<Articles> findArticlesById(@PathVariable("id") int id) {
        return articlesRepository.findById(id);
    }

    @PostMapping("/articles")
    public Articles saveArticles(@RequestBody Articles articles) {
        return articlesRepository.save(articles);
    }

    /*comments store service*/ //TODO
    @GetMapping("/comments")
    public Collection<Comments> getFindAllComments() {
        return commentsRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Optional<Comments> findCommentsById(@PathVariable("id") int id) {
        return commentsRepository.findById(id);
    }

    @PostMapping("/comments")
    public Comments saveComments(@RequestBody Comments comments) {
        return commentsRepository.save(comments);
    }

}

