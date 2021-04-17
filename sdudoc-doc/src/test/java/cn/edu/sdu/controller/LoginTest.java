package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
import cn.edu.sdu.service.UmsUserService;
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
        Optional<UmsUser> user = repository.findById("1");
//        JSONObject result = (JSONObject) login.login(user);
//        System.out.println(result.get("token"));
        System.out.println(user.get().getPassword());
//        System.out.println(hello.hello());
    }
}
