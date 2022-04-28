package com.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String userName;
    private String email;
    private String password;
    private String confirmPasswords;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "comments_id")
//    private Comments comments;

}
