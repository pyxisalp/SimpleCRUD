package com.example.simpleCRUD.service;

import com.example.simpleCRUD.dto.ArticleForm;
import com.example.simpleCRUD.entity.Article;
import com.example.simpleCRUD.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    // 게시글 전체 조회
    public List<Article> index() {
        return articleRepository.findAll();
    }

    // 게시글 1개 조회
    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 게시글 생성
    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }

        return articleRepository.save(article);
    }

    // 게시글 수정
    public Article update(Long id, ArticleForm dto) {
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null || id != article.getId()) {
            return null;
        }

        target.patch(article);
        Article updated = articleRepository.save(target);

        return updated;
    }

    // 게시글 삭제
    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }

        articleRepository.delete(target);

        return target;
    }
}
