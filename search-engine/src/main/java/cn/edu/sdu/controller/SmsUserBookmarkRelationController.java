package cn.edu.sdu.controller;

import cn.edu.sdu.entity.ds2.SmsUserBookmarkRelation;
import cn.edu.sdu.service.SmsUserBookmarkRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookmark")
public class SmsUserBookmarkRelationController {

    @Autowired
    SmsUserBookmarkRelationService smsUserBookmarkRelationService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public SmsUserBookmarkRelation insert(String username, String aid){
        return smsUserBookmarkRelationService.insert(username, aid);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, String>> find(String username){
        return smsUserBookmarkRelationService.find(username);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String username, String aid){
        try{
            smsUserBookmarkRelationService.delete(username, aid);
            return "200";
        }catch (Exception e){
            return e.toString();
        }

    }

    @RequestMapping(value = "/exist", method = RequestMethod.POST)
    @ResponseBody
    public Boolean exist(String username, String aid){
        return smsUserBookmarkRelationService.exist(username, aid);
    }

}
