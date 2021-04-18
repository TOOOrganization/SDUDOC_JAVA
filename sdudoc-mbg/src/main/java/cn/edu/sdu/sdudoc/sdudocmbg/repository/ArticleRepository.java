package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article,String> {

    List<Article> saveAll(Iterable articles);

    List<Article> findAll();

    List<Article> findBybookname(String bookname);

    List<Article> findByTitle(String title);

    List<Article> findByArticleAuthor(String articleAuthor);
}
