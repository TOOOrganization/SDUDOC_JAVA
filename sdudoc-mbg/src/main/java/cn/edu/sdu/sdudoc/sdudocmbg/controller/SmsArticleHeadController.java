package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.SmsArticleHead;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.SmsArticleHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sms_article_head")
public class SmsArticleHeadController {
    @Autowired
    private SmsArticleHeadRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<SmsArticleHead> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    SmsArticleHead save(SmsArticleHead entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<SmsArticleHead> saveAll(List<SmsArticleHead> list){
        return repository.saveAll(list);
    }

}
