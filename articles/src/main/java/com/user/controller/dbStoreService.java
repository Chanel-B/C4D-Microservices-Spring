package com.user.controller;

import com.user.model.Articles;
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

        List<Comments> commentsList = commentsRepository.findAll();
        model.addAttribute("commentsList", commentsList);

        return "imageDetails";
    }

    @GetMapping("/gallery")
    public String getGalleryImages(Model model) {
        model.addAttribute("gallery", new Articles());
        return "gallery";
    }

    @PostMapping("/imageDetails")
    public String commentSubmitForm(@ModelAttribute Comments comment, Model model) {
        Comments newComment = new Comments();
        comment.setProfession("artist");
        newComment.setComment(checkComment(comment));
        newComment.setUserName(comment.getUserName());
        newComment.setProfession(getProfession(comment));
        commentsRepository.save(newComment);

        //redirect the home page to it self to show
        return "redirect:/imageDetails";
    }

    private String getProfession(Comments comment) {

        if (comment.getProfession() == null)
            return "";
        else
            return "Profession : " + comment.getProfession();
    }

    private String checkComment(Comments comment) {
        return comment.getComment().replaceAll("\\n", " ");
    }

}

