package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsUser;
import cn.edu.sdu.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UmsUserController {

    @Autowired
    private UmsUserService umsUserService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<UmsUser> findAll(){
        return umsUserService.findAll();
    }
}
