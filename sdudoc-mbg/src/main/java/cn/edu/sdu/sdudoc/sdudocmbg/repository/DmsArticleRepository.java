package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DmsArticleRepository extends MongoRepository<DmsArticle,String> {

    List<DmsArticle> saveAll(Iterable articles);

    List<DmsArticle> findAll();

    List<DmsArticle> findBybookname(String bookname);

    List<DmsArticle> findByTitle(String title);

    List<DmsArticle> findByArticleAuthor(String articleAuthor);
}