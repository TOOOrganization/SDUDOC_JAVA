package cn.edu.sdu.sdudoc.sdudocmanager.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmanager.service.DmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class DmsArticleController {

    @Autowired
    private DmsArticleService dmsArticleService;

    @RequestMapping("/findAll")
    @ResponseBody
    List<DmsArticle> findAll() {
        return dmsArticleService.findAll();
    }

}
