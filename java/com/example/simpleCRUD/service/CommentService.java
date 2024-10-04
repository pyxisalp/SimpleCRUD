package com.example.simpleCRUD.service;

import com.example.simpleCRUD.dto.CommentDto;
import com.example.simpleCRUD.entity.Article;
import com.example.simpleCRUD.entity.Comment;
import com.example.simpleCRUD.repository.ArticleRepository;
import com.example.simpleCRUD.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    // 댓글 생성
    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("게시글 조회 실패"));
        Comment comment = Comment.createComment(dto, article);
        Comment created = commentRepository.save(comment);

        return CommentDto.createCommentDto(created);
    }

    // 댓글 수정
    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 조회 실패"));
        target.patch(dto);
        Comment updated = commentRepository.save(target);

        return CommentDto.createCommentDto(updated);
    }

    // 댓글 삭제
    @Transactional
    public CommentDto delete(Long id) {
        Comment target = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 조회 실패"));
        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }
}
