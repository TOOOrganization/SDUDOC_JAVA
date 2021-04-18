package cn.edu.sdu.sdudoc.controller;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.service.ArticleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@EnableAutoConfiguration
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/findAll")
    @ResponseBody
    List<Article> findAll() {
        return articleService.findAll();
    }

}
