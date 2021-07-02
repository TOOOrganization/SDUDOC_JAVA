package cn.edu.sdu.mysql.controller;

import cn.edu.sdu.mysql.service.SmsArticleHeadService;
import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article_head")
public class SmsArticleHeadController {

    @Autowired
    SmsArticleHeadService smsArticleHeadService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> save(String smsArticleHead){
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.save(JSON.parseObject(smsArticleHead, SmsArticleHead.class))));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.findAll()));
    }

    @RequestMapping(value = "/findAllById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAllById(String ids){
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.findAllById(ids)));
    }

    @RequestMapping(value = "/findAll_id", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll_id(){
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.findAll_id()));
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> find(String field, String keyword){
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.find(field, keyword)));
    }

    @RequestMapping("/findMany")
    @ResponseBody
    public CommonResult<String> findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.findMany(field, keyword)));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        smsArticleHeadService.delete(id);
    }

    @RequestMapping("/deleteMany")
    @ResponseBody
    public void deleteMany(String entities) {
        smsArticleHeadService.deleteMany(entities);
    }
}
