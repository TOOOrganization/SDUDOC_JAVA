package cn.edu.sdu.searchengine.repository;

import cn.edu.sdu.searchengine.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article,String> {

    List<Article> saveAll(Iterable articles);

    List<Article> findAll();

    List<Article> findByBookname(String bookname);

    List<Article> findByTitle(String title);

    List<Article> findByArticleAuthor(String articleAuthor);

}
