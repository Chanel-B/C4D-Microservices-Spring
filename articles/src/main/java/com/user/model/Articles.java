package com.user.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Articles")
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    private String shotDescription;
    private String longDescription;
    private int ratings;
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "comments_id")
//    private List<Comments> comments;

}
