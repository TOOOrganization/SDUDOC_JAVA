package cn.edu.sdu.searchengine.service;

import cn.edu.sdu.searchengine.entity.Article;

import java.util.List;

public interface ArticleService {

    void save(Article article);

    List<Article> saveAll(List articles);

    void delete(String id);

    void update(Article article);

    List<Article> findAll();

    List<Article> findByBookname(String bookname);

    List<Article> findByTitle(String title);

    List<Article> findByArticleAuthor(String articleAuthor);
}
