package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsArticleRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class DmsArticleServiceImpl implements DmsArticleService {

    @Resource
    private DmsArticleRepository dmsArticleRepository;

    @Override
    public DmsArticle save(DmsArticle dmsArticle) {
        return dmsArticleRepository.save(dmsArticle);
    }

    @Override
    public List<DmsArticle> saveAll(List articles){
        return dmsArticleRepository.saveAll(articles);
    }

    @Override
    public void delete(String id) {
        dmsArticleRepository.deleteById(id);
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
    public void update(DmsArticle dmsArticle){
        dmsArticleRepository.save(dmsArticle);
    }

    @Override
    public Optional<DmsArticle> findOne(DmsArticle dmsArticle){ return dmsArticleRepository.findOne(Example.of(dmsArticle));}

    @Override
    public Optional<DmsArticle> findById(String id){ return dmsArticleRepository.findById(id);}

    @Override
    public List<DmsArticle> findAll() {
        return dmsArticleRepository.findAll();
    }

    @Override
    public List<DmsArticle> findBybookname(String bookname) {
        return dmsArticleRepository.findBybookname(bookname);
    }

    @Override
    public List<DmsArticle> findByTitle(String title){
        return dmsArticleRepository.findByTitle(title);
    }

    @Override
    public List<DmsArticle> findByArticleAuthor(String articleAuthor){
        return dmsArticleRepository.findByArticleAuthor(articleAuthor);
    }

}
