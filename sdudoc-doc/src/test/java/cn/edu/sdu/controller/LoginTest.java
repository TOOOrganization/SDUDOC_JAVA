package cn.edu.sdu.controller;

import cn.edu.sdu.entity.ds1.UmsUser;
import cn.edu.sdu.repository.ds1.UmsUserRepository;
import com.alibaba.fastjson.JSONObject;
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
    public void getLogin() {}

    @Test
    public void register() {}
}
