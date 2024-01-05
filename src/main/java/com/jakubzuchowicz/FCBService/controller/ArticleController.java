package com.jakubzuchowicz.FCBService.controller;

import com.jakubzuchowicz.FCBService.model.Article;
import com.jakubzuchowicz.FCBService.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barka")
public class ArticleController {

    private final ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService) {this.articleService = articleService;}

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.findArticleById(id);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article newArticle) {
        Article savedArticle = articleService.addArticle(newArticle);
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Article updated = articleService.updateArticle(id, updatedArticle);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
