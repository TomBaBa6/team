package com.etc.controller;

import com.etc.entity.Article;
import com.etc.service.ArticleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/getuser/{uid}")
    public Map<String,Object> getUser(@PathVariable Integer uid){
        Map<String,Object> map = restTemplate.getForObject("http://localhost:8762/user/get/"+uid,Map.class);
        return map;
    }

    @RequestMapping("/get/{articleId}")
    public Article getArticle(@PathVariable Integer articleId){
        return articleService.getById(articleId);
    }

    @RequestMapping("/getdetail/{articleId}")
    public Map<String,Object> getArticleDetail(@PathVariable Integer articleId){
        Article a = articleService.getById(articleId);
        Map<String,Object> map = new HashMap<>();
        if(a.getAuthorId() != null){
            map = restTemplate.getForObject("http://localhost:8762/user/get/"+a.getAuthorId(),Map.class);
        }
        if(a != null){//把文章中的属性设置到map中
            map.put("articleId",a.getArticleId());
            map.put("articleTitle",a.getArticleTitle());
            map.put("articleContent",a.getArticleContent());
            map.put("articleDt",a.getArticleDt());
        }
        return map;
    }
}
