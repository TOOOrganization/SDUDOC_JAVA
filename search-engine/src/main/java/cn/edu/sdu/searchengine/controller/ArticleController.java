package cn.edu.sdu.searchengine.controller;

import cn.edu.sdu.searchengine.entity.Article;
import cn.edu.sdu.searchengine.repository.ArticleRepository;
import cn.edu.sdu.searchengine.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll")
    @ResponseBody
    List<Article> findAll() {
        return articleService.findAll();
    }

}
