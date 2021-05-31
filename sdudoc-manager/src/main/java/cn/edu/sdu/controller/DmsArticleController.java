package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.service.DmsArticleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/article")
public class DmsArticleController {

    @Autowired
    private DmsArticleService dmsArticleService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public String findAll() {
        return JSON.toJSONString(dmsArticleService.findAll());
    }

    @RequestMapping(value = "/findAll_id", method = RequestMethod.GET)
    @ResponseBody
    public String findAll_id() {
        return JSON.toJSONString(dmsArticleService.findAll_id());
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return JSON.toJSONString(dmsArticleService.find(field, keyword));
    }

    @RequestMapping("/findMany")
    @ResponseBody
    public String findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return JSON.toJSONString(dmsArticleService.findMany(field, keyword));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        dmsArticleService.delete(id);
    }

    @RequestMapping("/deleteMany")
    @ResponseBody
    public void deleteMany(String entities) {
        dmsArticleService.deleteMany(entities);
    }

}
