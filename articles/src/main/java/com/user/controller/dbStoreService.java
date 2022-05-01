package com.user.controller;

import com.user.model.Comments;
import com.user.repository.ArticlesRepository;
import com.user.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RestController
public class dbStoreService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    private List<Comments> players = new ArrayList<>();

    @GetMapping("/imageDetails")
    public String getCommentsForm(Model model) {

        model.addAttribute("imageDetails", new Comments());
        return "imageDetails";
    }

    @PostMapping("/imageDetails")
    public String commentSubmitForm(@ModelAttribute Comments comment, Model model) {
        Comments newComment = new Comments();
        newComment.setComment(checkComment(comment));
        newComment.setUserName(comment.getUserName());
        newComment.setProfession("Artist Pro");
        commentsRepository.save(newComment);
        List<Comments> commentsList = commentsRepository.findAll();

        model.addAttribute("commentsList", commentsList);

//        model.addAttribute("imageDetails", comment);
        System.out.println(commentsRepository.findAll());

        //redirect the home page to it self to show
        return "redirect:/imageDetails";
    }

    private String checkComment(Comments comment) {
        return comment.getComment().replaceAll("\\n", " ");
    }


//    /*article store service*/ //TODO
//    @GetMapping("/articles")
//    public Collection<Articles> getFindAllArticles() {
//        return articlesRepository.findAll();
//    }
//
//    @GetMapping("/articles/{id}")
//    public Optional<Articles> findArticlesById(@PathVariable("id") int id) {
//        return articlesRepository.findById(id);
//    }
//
//    @PostMapping("/articles")
//    public Articles saveArticles(@RequestBody Articles articles) {
//        return articlesRepository.save(articles);
//    }
//
//    /*comments store service*/ //TODO
//    @GetMapping("/comments")
//    public Collection<Comments> getFindAllComments() {
//        return commentsRepository.findAll();
//    }
//
//    @GetMapping("/comments/{id}")
//    public Optional<Comments> findCommentsById(@PathVariable("id") int id) {
//        return commentsRepository.findById(id);
//    }
//
//    @PostMapping("/comments")
//    public Comments saveComments(@RequestBody Comments comments) {
//        return commentsRepository.save(comments);
//    }

}

