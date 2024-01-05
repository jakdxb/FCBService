package com.jakubzuchowicz.FCBService.controller;
import com.jakubzuchowicz.FCBService.model.Comment;
import com.jakubzuchowicz.FCBService.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barka")
public class CommentController {
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {this.commentService = commentService;}

    @PostMapping("/comments/{articleId}")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment, @PathVariable Long articleId) {
        Comment savedComment = commentService.saveComment(comment, articleId);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comments/search")
    public ResponseEntity<List<Comment>> getCommentContaining(@RequestParam String text) {
        List<Comment> comments = commentService.getCommentContaining(text);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        String result = commentService.deleteComment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
