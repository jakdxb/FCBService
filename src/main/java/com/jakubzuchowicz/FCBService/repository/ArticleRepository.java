package com.jakubzuchowicz.FCBService.repository;
import com.jakubzuchowicz.FCBService.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}