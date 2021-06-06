package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.service.DmsArticleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("hasAnyRole('administrator', 'administrator_mongo')")
@RestController
@RequestMapping("/article")
public class DmsArticleController {

    @Autowired
    private DmsArticleService dmsArticleService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll() {
        return CommonResult.success(JSON.toJSONString(dmsArticleService.findAll()));
    }

    @RequestMapping(value = "/findAll_id", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll_id() {
        return CommonResult.success(JSON.toJSONString(dmsArticleService.findAll_id()));
    }

    @RequestMapping("/find")
    @ResponseBody
    public CommonResult<String> find(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(dmsArticleService.find(field, keyword)));
    }

    @RequestMapping("/findMany")
    @ResponseBody
    public CommonResult<String> findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(dmsArticleService.findMany(field, keyword)));
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
