package com.example.demo.user.model;

import com.example.demo.article.model.Article;
import com.example.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name="users")
@Builder
public class User extends BaseEntity {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        private String username;
    private String password;
    private String name;
    private String phone;
    private Long addressId;
    private String job;
    private String token;
    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Article> articles;
}