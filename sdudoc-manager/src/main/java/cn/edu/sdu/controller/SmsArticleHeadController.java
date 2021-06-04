package cn.edu.sdu.controller;


import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.service.SmsArticleHeadService;
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

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        return CommonResult.success(JSON.toJSONString(smsArticleHeadService.findAll()));
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

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id) {
        smsArticleHeadService.delete(id);
    }
}
