package com.etc.dao;

import com.etc.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article>, Serializable {

    public Article findByArticleId(Integer id);

}
