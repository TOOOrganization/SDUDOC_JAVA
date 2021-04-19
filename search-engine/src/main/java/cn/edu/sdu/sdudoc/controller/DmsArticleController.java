package cn.edu.sdu.sdudoc.controller;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@EnableAutoConfiguration
public class DmsArticleController {

    @Resource
    private DmsArticleService dmsArticleService;

    @RequestMapping("/findAll")
    @ResponseBody
    List<DmsArticle> findAll() {
        return dmsArticleService.findAll();
    }

}
