package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
import cn.edu.sdu.service.UmsUserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class LoginTest {
    @Autowired
    LoginController login;
    @Autowired
    UmsUserRepository repository;

    @Test
    public void getLogin() {
//        Optional<UmsUser> user = repository.findById("111");
//        if (user.isPresent()) {
//            JSONObject result = (JSONObject) login.login(user.get());
//            System.out.println(result.get("token"));
//            System.out.println(result);
//        }else {
//            System.out.println("sb");
//        }
        UmsUser user = new UmsUser();
        user.setUid("123");
        user.setUsername("222");
        user.setPassword("222");
        user.setStatus(0);
        user.setCount(0);
        JSONObject result = (JSONObject) login.login(user);
        System.out.println(result);
        System.out.println(login.getMessage());

//        System.out.println(LoginController.login(user.get()));
//        System.out.println(hello.hello());
    }
}
