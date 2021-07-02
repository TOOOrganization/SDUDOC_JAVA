package cn.edu.sdu.manager.controller;

import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.manager.service.DmsArticleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/article")
public class DmsArticleController {

    @Autowired
    private DmsArticleService dmsArticleService;

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll() {
        return CommonResult.success(JSON.toJSONString(dmsArticleService.findAll()));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping(value = "/findAll_id", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll_id() {
        return CommonResult.success(JSON.toJSONString(dmsArticleService.findAll_id()));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping("/find")
    @ResponseBody
    public CommonResult<String> find(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(dmsArticleService.find(field, keyword)));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping("/findMany")
    @ResponseBody
    public CommonResult<String> findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(dmsArticleService.findMany(field, keyword)));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo')")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        dmsArticleService.delete(id);
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo')")
    @RequestMapping("/deleteMany")
    @ResponseBody
    public void deleteMany(String entities) {
        dmsArticleService.deleteMany(entities);
    }

}
