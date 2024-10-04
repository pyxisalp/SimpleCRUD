package com.example.simpleCRUD.repository;

import com.example.simpleCRUD.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 게시글의 전체 댓글 보기
    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    // 특정 유저의 전체 댓글 보기
    List<Comment> findByNickname(String nickname);
}
