package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.UmsUserRepository;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ds1_user")
public class Ds1UmsUserController {

    @Autowired
    private UmsUserRepository umsUserRepository;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        return CommonResult.success(JSON.toJSONString(umsUserRepository.findAll()));
    }
}
