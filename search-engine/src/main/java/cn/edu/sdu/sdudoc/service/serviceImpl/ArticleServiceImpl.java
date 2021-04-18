package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ArticleRepository;
import cn.edu.sdu.sdudoc.service.ArticleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public void save(Article article) {

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
    public List<Article> findBybookname(String bookname) {
        return articleRepository.findBybookname(bookname);
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
