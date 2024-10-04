package com.example.simpleCRUD.controller;

import com.example.simpleCRUD.dto.ArticleForm;
import com.example.simpleCRUD.dto.CommentDto;
import com.example.simpleCRUD.entity.Article;
import com.example.simpleCRUD.repository.ArticleRepository;
import com.example.simpleCRUD.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    // 게시글 작성
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    // 게시글 작성
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
//        log.info(form.toString());

        Article article = form.toEntity();
//        log.info(article.toString());

        Article saved = articleRepository.save(article);
//        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    // 게시글 1개 보기
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        // 데이터 로드
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentsDtos = commentService.comments(id);

        // 데이터 등록
        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentsDtos);

        return "articles/show";
    }

    // 게시글 전체 보기
    @GetMapping("/articles")
    public String index(Model model) {
        // 데이터 로드
        ArrayList<Article> articleEntityList = articleRepository.findAll();

        // 데이터 등록
        model.addAttribute("articleList", articleEntityList);

        return "articles/index";
    }

    // 게시글 수정
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 데이터 로드
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 데이터 등록
        model.addAttribute("article", articleEntity);

        return "articles/edit";
    }

    // 게시글 수정
    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
//        log.info(form.toString());

        Article articleEntity = form.toEntity();
//        log.info(articleEntity.toString());

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        if (target != null) {
            articleRepository.save(articleEntity);
        }

        return "redirect:/articles/" + articleEntity.getId();
    }

    // 게시글 삭제
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        // 데이터 로드
        Article target = articleRepository.findById(id).orElse(null);

        // 데이터 삭제
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료");
        }

        return "redirect:/articles";
    }
}

