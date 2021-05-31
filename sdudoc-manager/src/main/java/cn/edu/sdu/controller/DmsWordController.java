package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsWord;
import cn.edu.sdu.service.DmsWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/word")
public class DmsWordController {

    @Autowired
    DmsWordService dmsWordService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<DmsWord> findAll(){
        return dmsWordService.findAll();
    }

    @RequestMapping(value = "/findAllArticle", method = RequestMethod.GET)
    @ResponseBody
    public Set<String> findAllArticle(){
        return dmsWordService.findAllArticle();
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<DmsWord> find(String field, String keyword) {
        return dmsWordService.find(field, keyword);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        dmsWordService.delete(id);
    }
}
