package com.etc.service.Impl;

import com.etc.dao.ArticleDao;
import com.etc.entity.Article;
import com.etc.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;


    @Override
    public Article getById(Integer id) {
        return articleDao.findByArticleId(id);
    }
}
