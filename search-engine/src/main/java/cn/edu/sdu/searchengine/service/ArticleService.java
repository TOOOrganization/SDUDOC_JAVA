package cn.edu.sdu.searchengine.service;

import cn.edu.sdu.searchengine.entity.Article;

import java.util.List;

public interface ArticleService {

    void save(Article article);

    void delete(String id);

    void update(Article article);

    List<Article> findAll();

    List<Article> findBybookname(String bookname);

    List<Article> saveAll(List articles);
}
