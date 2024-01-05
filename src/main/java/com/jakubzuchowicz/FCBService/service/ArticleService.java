package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.model.Article;
import com.jakubzuchowicz.FCBService.model.Player;
import com.jakubzuchowicz.FCBService.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleService(ArticleRepository articleRepository) {this.articleRepository = articleRepository; }


    public Article findArticleById(Long articleId) { return articleRepository.findById(articleId).orElse(null); }

    public Article addArticle(Article newArticle) {
        if (newArticle == null) {
            throw new IllegalArgumentException("Nowy artykul nie może być null");
        }
        return articleRepository.save(newArticle);
    }

    public void deleteArticle(Long articleId) {
        if (!articleRepository.existsById(articleId)) {
            throw new IllegalArgumentException("Artykul o podanym ID nie istnieje");
        }
        articleRepository.deleteById(articleId);
    }

    public Article updateArticle(Long articleId, Article updatedArticle) {
        Article existingArticle = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Artykuł o podanym ID nie istnieje"));

        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setContent(updatedArticle.getContent());

        return articleRepository.save(existingArticle);
    }




}
