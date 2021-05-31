package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;

import java.util.List;
import java.util.Optional;

public interface DmsArticleService {

    DmsArticle save(DmsArticle dmsArticle);

    List<DmsArticle> saveAll(List<DmsArticle> articles);

    void delete(String id);

    void deleteMany(String entities);

    void update(DmsArticle dmsArticle);

    Optional<DmsArticle> findOne(DmsArticle dmsArticle);

    Optional<DmsArticle> findById(String id);

    List<DmsArticle> findAll();

    List<String> findAll_id();

    List<DmsArticle> find(String field, String keyword);

    List<DmsArticle> findMany(String field, String keyword);

//    List<DmsArticle> findByBookname(String bookname);
//
//    List<DmsArticle> findByTitle(String title);
//
//    List<DmsArticle> findByArticleAuthor(String articleAuthor);
//
//    List<DmsArticle> findByDynasty(String dynasty);
//
//    List<DmsArticle> findByContent(String content);
}
