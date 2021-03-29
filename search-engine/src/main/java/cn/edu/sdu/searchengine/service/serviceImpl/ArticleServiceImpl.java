package cn.edu.sdu.searchengine.service.serviceImpl;

import cn.edu.sdu.searchengine.entity.Article;
import cn.edu.sdu.searchengine.repository.ArticleRepository;
import cn.edu.sdu.searchengine.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    public List<Article> findBybookname(String bookname) {
        return articleRepository.findBybookname(bookname);
    }

    @Override
    public List<Article> saveAll(List articles){
        return articleRepository.saveAll(articles);
    }

}
