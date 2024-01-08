package com.jakubzuchowicz.FCBService.repository;
import com.jakubzuchowicz.FCBService.model.Article;
import com.jakubzuchowicz.FCBService.model.Match;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

    Article findTop1By(Sort sort);
}