package com.jakubzuchowicz.FCBService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Size(min = 3, max = 30, message = "Tytul powinien składać się z conajmniej 3 liter.")
    @NotNull
    private String title;

    @Size(min = 100, max = 5000, message = "Artykul powinien składać się z conajmniej 100 liter.")
    @NotNull
    private String content;

    @NotNull
    private String ImageUrl;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Comment> comments;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
