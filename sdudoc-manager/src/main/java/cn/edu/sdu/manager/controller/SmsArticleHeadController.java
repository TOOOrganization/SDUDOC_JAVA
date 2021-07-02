package cn.edu.sdu.manager.controller;


import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.common.util.OkHttpUtil;
import cn.edu.sdu.manager.service.SmsArticleHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@PreAuthorize("hasAnyRole('administrator', 'administrator_mysql')")
@RestController
@RequestMapping("/article_head")
public class SmsArticleHeadController {

    @Autowired
    SmsArticleHeadService smsArticleHeadService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll() throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/findAll";
        String result = OkHttpUtil.doGet(url,"GET");
        return CommonResult.success(result);
    }

    @RequestMapping(value = "/findAll_id", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll_id() throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/findAll_id";
        String result = OkHttpUtil.doGet(url,"GET");
        return CommonResult.success(result);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> find(String field, String keyword) throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/find";
        Map<String, String> map = new HashMap<>();
        map.put("field", field);
        map.put("keyword", keyword);
        String result = OkHttpUtil.doPost(url, map, "POST");
        return CommonResult.success(result);
    }

    @RequestMapping("/findMany")
    @ResponseBody
    public CommonResult<String> findMany(String field, String keyword) throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/findMany";
        Map<String, String> map = new HashMap<>();
        map.put("field", field);
        map.put("keyword", keyword);
        String result = OkHttpUtil.doPost(url, map, "POST");
        System.out.println(result);
        return CommonResult.success(result);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/delete";
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        String result = OkHttpUtil.doPost(url, map, "POST");
    }

    @RequestMapping("/deleteMany")
    @ResponseBody
    public void deleteMany(String entities) throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/deleteMany";
        Map<String, String> map = new HashMap<>();
        map.put("entities", entities);
        String result = OkHttpUtil.doPost(url, map, "POST");
    }
}
