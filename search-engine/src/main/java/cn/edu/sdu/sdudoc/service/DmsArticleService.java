package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface DmsArticleService {

    DmsArticle save(DmsArticle dmsArticle);

    List<DmsArticle> saveAll(List articles);

    void delete(String id);

    void update(DmsArticle dmsArticle);

    Optional<DmsArticle> findOne(DmsArticle dmsArticle);

    Optional<DmsArticle> findById(String id);

    List<DmsArticle> findAll();

    List<DmsArticle> findBybookname(String bookname);

    List<DmsArticle> findByTitle(String title);

    List<DmsArticle> findByArticleAuthor(String articleAuthor);
}
