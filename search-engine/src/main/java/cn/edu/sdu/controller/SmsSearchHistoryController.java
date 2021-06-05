package cn.edu.sdu.controller;

import cn.edu.sdu.entity.ds2.SmsSearchHistory;
import cn.edu.sdu.service.SmsSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shis")
public class SmsSearchHistoryController {

    @Autowired
    SmsSearchHistoryService smsSearchHistoryService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public SmsSearchHistory insert(String username, String word, Integer type){
        return smsSearchHistoryService.insert(username, word, type);
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, String>> find(String username, Integer type){
        return smsSearchHistoryService.find(username, type);
    }

}
