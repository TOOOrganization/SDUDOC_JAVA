package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;
import cn.edu.sdu.service.DmsCharacterService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/character")
public class DmsCharacterController {

    @Autowired
    DmsCharacterService dmsCharacterService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<DmsCharacter> findAll(){
        return dmsCharacterService.findAll();
    }

    @RequestMapping(value = "/findAllArticle", method = RequestMethod.GET)
    @ResponseBody
    public Set<String> findAllArticle(){
        return dmsCharacterService.findAllArticle();
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public List<DmsCharacter> find(String field, String keyword){
        return dmsCharacterService.find(field, keyword);
    }

    @RequestMapping("/findMany")
    @ResponseBody
    public String findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return JSON.toJSONString(dmsCharacterService.findMany(field, keyword));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        dmsCharacterService.delete(id);
    }
}
