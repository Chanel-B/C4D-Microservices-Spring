package com.user.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private String userName;
    private String profession;
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "articles_id")
//    private Articles articles;
}
