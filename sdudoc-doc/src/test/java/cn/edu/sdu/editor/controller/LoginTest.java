package cn.edu.sdu.editor.controller;

import cn.edu.sdu.repository.ds1.UmsUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
