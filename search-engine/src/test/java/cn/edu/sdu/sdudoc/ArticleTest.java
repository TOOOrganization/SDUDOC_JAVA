package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.entity.Article;
import cn.edu.sdu.sdudoc.service.ArticleService;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void insertOne(){
        Article article = new Article();
        article.setBookname("qqq");
        articleService.save(article);
    }

    @Test
    public void insertMany(){
        Article article1 = new Article();
        article1.setBookname("111");
        Article article2 = new Article();
        article2.setBookname("222");
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articleService.saveAll(articles);
    }

    @Test
    public void findAll() {
        String s = JSONObject.toJSONString(articleService.findAll());
        System.out.println(s);
    }

    @Test
    public void findBybookname(){
        System.out.println(JSONObject.toJSONString(articleService.findBybookname("123")));
    }

    @Test
    public void findByTitle(){
        System.out.println(JSONObject.toJSONString(articleService.findByTitle("test")));
    }

    @Test
    public void findByArticleAuthor(){
        System.out.println(JSONObject.toJSONString(articleService.findByArticleAuthor("李白")));
    }

}
