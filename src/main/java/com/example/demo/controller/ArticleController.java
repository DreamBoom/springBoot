package com.example.demo.controller;

import com.example.demo.generator.Article;
import com.example.demo.generator.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("/rest")
@RestController
public class ArticleController {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private ArticleMapper articleMapper;
    @GetMapping("/getArticle")
    public AjaxResponse getArticle(String id){
        if(articleMapper.selectById(id)==null){
            return AjaxResponse.error("暂无数据");
        }
        Article article = articleMapper.selectById(id);
        return AjaxResponse.success(article);
    }
    @GetMapping("/getArticles")
    public AjaxResponse getArticles(){
        List<Article> articles = articleMapper.selectList(null);
        return AjaxResponse.success(articles);
    }

    @PostMapping("/saveArticle")
    public AjaxResponse saveArticle(String author, String content, String creattime, String title) throws ParseException {
        Article article = new Article();
        article.setTitle(title);
        article.setCreattime(simpleDateFormat.parse(creattime));
        article.setContent(content);
        article.setAuthor(author);
        int insert = articleMapper.insert(article);
        if(insert>0){
            return AjaxResponse.success();
        }else {
            return AjaxResponse.error("新增失败");
        }
    }

    @PostMapping("/upDataArticle")
    public AjaxResponse upDataArticle(int id,String author, String creattime,String content, String title) throws ParseException {
        if(articleMapper.selectById(id)==null){
            return AjaxResponse.error("修改失败，无此数据");
        }
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setCreattime(simpleDateFormat.parse(creattime));
        article.setContent(content);
        article.setAuthor(author);
        articleMapper.updateById(article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/deleteArticle")
    public AjaxResponse deleteArticle(String id){
        if(articleMapper.selectById(id)==null){
            return AjaxResponse.error("删除失败，无此数据");
        }
        articleMapper.deleteById(id);
        return AjaxResponse.success();
    }
}
