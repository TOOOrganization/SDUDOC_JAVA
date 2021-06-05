package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.DmsArticle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds2DmsArticleRepository")
public interface DmsArticleRepository extends MongoRepository<DmsArticle,String> {

    List<DmsArticle> saveAll(Iterable articles);

    List<DmsArticle> findAll();

    List<DmsArticle> findBybookname(String bookname);

    List<DmsArticle> findByTitle(String title);

    List<DmsArticle> findByArticleAuthor(String articleAuthor);
}
