package com.user.model;

import com.sun.istack.NotNull;
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
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "articles_id")
//    private Articles articles;
}
