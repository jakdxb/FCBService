package com.jakubzuchowicz.FCBService.service;
import com.jakubzuchowicz.FCBService.model.Article;
import com.jakubzuchowicz.FCBService.model.Comment;
import com.jakubzuchowicz.FCBService.repository.ArticleRepository;
import com.jakubzuchowicz.FCBService.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public Comment saveComment(Comment comment, Long id){
        Article article = articleRepository.findById(id).orElse(null);
        comment.setArticle(article);
        article.addComment(comment);
        articleRepository.save(article);
        return commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> getCommentContaining(String text) {
        return commentRepository.findCommentsByTextContaining(text);
    }

    public String deleteComment(Long id) {
        commentRepository.deleteById(id);
        return "Comment " + id + " removed";
    }


}
