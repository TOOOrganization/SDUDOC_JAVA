package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.service.DmsWordService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class DmsWordController {

    @Autowired
    DmsWordService dmsWordService;

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        return CommonResult.success(JSON.toJSONString(dmsWordService.findAll()));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping(value = "/findAllArticle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAllArticle(){
        return CommonResult.success(JSON.toJSONString(dmsWordService.findAllArticle()));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping("/find")
    @ResponseBody
    public CommonResult<String> find(String field, String keyword) {
        return CommonResult.success(JSON.toJSONString(dmsWordService.find(field, keyword)));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo', 'reader')")
    @RequestMapping("/findMany")
    @ResponseBody
    public CommonResult<String> findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(dmsWordService.findMany(field, keyword)));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo')")
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        dmsWordService.delete(id);
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_mongo')")
    @RequestMapping("/deleteMany")
    @ResponseBody
    public void deleteMany(String entities) {
        dmsWordService.deleteMany(entities);
    }
}
