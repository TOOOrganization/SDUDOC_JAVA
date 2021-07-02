package cn.edu.sdu.search.controller;

import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.entity.ds2.SmsUserBookmarkRelation;
import cn.edu.sdu.search.service.SmsUserBookmarkRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<SmsArticleHead> find(String username) throws HttpStatusException {
        return smsUserBookmarkRelationService.find(username);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(String username, String aid){
        smsUserBookmarkRelationService.delete(username, aid);
    }

    @RequestMapping(value = "/exist", method = RequestMethod.POST)
    @ResponseBody
    public Boolean exist(String username, String aid){
        return smsUserBookmarkRelationService.exist(username, aid);
    }

}
