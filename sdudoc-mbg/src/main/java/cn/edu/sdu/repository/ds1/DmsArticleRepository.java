package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.DmsArticle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds1DmsArticleRepository")
public interface DmsArticleRepository extends MongoRepository<DmsArticle,String> {

    List<DmsArticle> saveAll(Iterable articles);

    List<DmsArticle> findAll();

    List<DmsArticle> findByBookname(String bookname);

    List<DmsArticle> findByTitle(String title);

    List<DmsArticle> findByArticleAuthor(String articleAuthor);

    List<DmsArticle> findByDynasty(String dynasty);

    List<DmsArticle> findByContent(String content);
}
