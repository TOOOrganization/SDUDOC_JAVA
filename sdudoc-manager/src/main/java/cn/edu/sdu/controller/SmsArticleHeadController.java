package cn.edu.sdu.controller;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.SmsArticleHead;
import cn.edu.sdu.service.SmsArticleHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article_head")
public class SmsArticleHeadController {

    @Autowired
    SmsArticleHeadService smsArticleHeadService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<SmsArticleHead> findAll(){
        return smsArticleHeadService.findAll();
    }

    @RequestMapping(value = "/findAll_id", method = RequestMethod.GET)
    @ResponseBody
    public List<String> findAll_id(){
        return smsArticleHeadService.findAll_id();
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public List<SmsArticleHead> find(String field, String keyword){
        return smsArticleHeadService.find(field, keyword);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        smsArticleHeadService.delete(id);
    }
}
