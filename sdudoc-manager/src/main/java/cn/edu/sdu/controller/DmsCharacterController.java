package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.service.DmsCharacterService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class DmsCharacterController {

    @Autowired
    DmsCharacterService dmsCharacterService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        return CommonResult.success(JSON.toJSONString(dmsCharacterService.findAll()));
    }

    @RequestMapping(value = "/findAllArticle", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAllArticle(){
        return CommonResult.success(JSON.toJSONString(dmsCharacterService.findAllArticle()));
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> find(String field, String keyword){
        return CommonResult.success(JSON.toJSONString(dmsCharacterService.find(field, keyword)));
    }

    @RequestMapping("/findMany")
    @ResponseBody
    public CommonResult<String> findMany(String field, String keyword) {
        System.out.println(field);
        System.out.println(keyword);
        return CommonResult.success(JSON.toJSONString(dmsCharacterService.findMany(field, keyword)));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        dmsCharacterService.delete(id);
    }
}
