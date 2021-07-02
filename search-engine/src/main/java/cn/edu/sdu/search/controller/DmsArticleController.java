package cn.edu.sdu.search.controller;


import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.search.service.DmsArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class DmsArticleController {

    @Resource
    private DmsArticleService dmsArticleService;

    @RequestMapping("/findAll")
    @ResponseBody
    List<DmsArticle> findAll() {
        return dmsArticleService.findAll();
    }

}
