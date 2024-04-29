package com.example.demo.article.repository;


import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    // JPQL Default방식
    @Query("select a from articles a where a.board.id = :boardId")
    public List<Article> getArticlesByBoardId(@Param("boardId") Long boardId);


    //Native방식
    @Query(value = "select * from articles a where a.board.id = :boardId", nativeQuery = true)
    List<Article> getArticlesByBoardId2(@Param("boardId") Long boardId);
    @Query(value = "SELECT * from articles a where a.board.id = :boardId", nativeQuery = true)
    List<Map<String,Object>> getReviewArticles(@Param("boardId") Long boardId);


    String articleDtoMapping = "new com.example.demo.article.model.ArticleDto(a.id,a.title,a.content,a.writer.name, a.board.id,a.regDate,a.modDate)";
    @Query("select "+ articleDtoMapping+" from articles a where a.board.id = :boardId")
    public List<Article> getArticleDtosByBoardId(@Param("boardId") Long boardId);


    List<Article> findAllByBoardId(Long id);

    List<Article> findAllByOrderByIdDesc();
}
