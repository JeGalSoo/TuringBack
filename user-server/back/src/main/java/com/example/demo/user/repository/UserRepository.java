package com.example.demo.user.repository;

import com.example.demo.article.model.Article;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    UserDto findUsersByJob(String job);

    @Modifying //싱태변화시킬때 사용
    @Query("update users set token=:token where id = :id")
    public void modifyTokenById(@Param("token")String token, @Param("id") Long id);

    boolean existsByUsername(String username);

    Boolean existsByToken(String token);

    List<Article> findAllByOrderByIdDesc();
}
