package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsArticleRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DmsDmsArticleServiceImpl implements DmsArticleService {

    @Resource
    private DmsArticleRepository dmsArticleRepository;

    @Override
    public void save(DmsArticle dmsArticle) {
        dmsArticleRepository.save(dmsArticle);
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
