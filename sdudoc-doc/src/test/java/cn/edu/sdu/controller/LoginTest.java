package cn.edu.sdu.controller;

import cn.edu.sdu.SdudocDocApplication;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserMapper;
import cn.edu.sdu.service.UmsUserService;
import cn.hutool.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    LoginController login;
    @Autowired
    UmsUserService service;
    @Autowired
    UmsUserMapper mapper;
    @Autowired
    HelloController hello;

    @Test
    public void getLogin() {
        UmsUser user = mapper.selectByPrimaryKey("1");
//        JSONObject result = (JSONObject) login.login(user);
//        System.out.println(result.get("token"));
        System.out.println(user.getPassword());
//        System.out.println(hello.hello());
    }
}
