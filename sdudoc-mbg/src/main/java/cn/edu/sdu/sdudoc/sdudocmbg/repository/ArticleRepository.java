package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}
