package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.entity.Article;

import java.util.List;

public interface ArticleService {

    void save(Article article);

    List<Article> saveAll(List articles);

    void delete(String id);

    void update(Article article);

    List<Article> findAll();

    List<Article> findBybookname(String bookname);

    List<Article> findByTitle(String title);

    List<Article> findByArticleAuthor(String articleAuthor);
}
