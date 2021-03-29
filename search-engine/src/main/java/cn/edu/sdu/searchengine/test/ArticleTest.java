package cn.edu.sdu.searchengine.test;

import cn.edu.sdu.searchengine.SearchEngineApplication;
import cn.edu.sdu.searchengine.entity.Article;
import cn.edu.sdu.searchengine.service.ArticleService;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

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

}
