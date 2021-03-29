package cn.edu.sdu.searchengine.service.serviceImpl;

import cn.edu.sdu.searchengine.entity.Article;
import cn.edu.sdu.searchengine.repository.ArticleRepository;
import cn.edu.sdu.searchengine.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> saveAll(List articles){
        return articleRepository.saveAll(articles);
    }

    @Override
    public void delete(String id) {
        articleRepository.deleteById(id);
    }

//    @Override
//    public void update(Article article) {
//        Query query = new Query(Criteria.where("_id").is(article.getId()));
//
//        Update update = new Update();
//        update.set("_id", article.getId());
//        update.set("articleAuthor", article.getArticleAuthor());
//        update.set("bookname", article.getBookName());
//        update.set("content", article.getContent());
//        update.set("imgurl", article.getImgUrl());
//        update.set("page", article.getPage());
//        update.set("title", article.getTitle());
//        update.set("XML", article.getXml());
//
//        mongoTemplate.updateFirst(query, update, Article.class);
//    }
    @Override
    public void update(Article article){
        articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> findByBookname(String bookname) {
        return articleRepository.findByBookname(bookname);
    }

    @Override
    public List<Article> findByTitle(String title){
        return articleRepository.findByTitle(title);
    }

    @Override
    public List<Article> findByArticleAuthor(String articleAuthor){
        return articleRepository.findByArticleAuthor(articleAuthor);
    }

}
