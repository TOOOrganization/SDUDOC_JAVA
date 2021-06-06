package cn.edu.sdu.controller;

import cn.edu.sdu.annonations.UserLoginToken;
import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.entity.ds2.UmsUser;
import cn.edu.sdu.repository.ds2.UmsUserRepository;
import cn.edu.sdu.service.Ds2ManagerUserDetailsService;
import cn.edu.sdu.service.TokenService;
import cn.edu.sdu.util.Base64Util;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UmsUserRepository service;
    @Autowired
    TokenService tokenService;

    @Autowired
    Ds2ManagerUserDetailsService ds2ManagerUserDetailsService;

    @PostMapping("/login")
    public CommonResult<String> login(String username, String password) {
        return ds2ManagerUserDetailsService.login(username, password);
    }

    @PostMapping("/register")
    public CommonResult<String> register(String username, String password, String nickname) {
        return ds2ManagerUserDetailsService.register(username, password, nickname);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/set_password")
    public CommonResult<String> setPassword(String username, String password, String confirmPassword) {
        return ds2ManagerUserDetailsService.setPassword(username, password, confirmPassword);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/get_by_username")
    public CommonResult<UmsUser> getByUsername(String username) {
        return ds2ManagerUserDetailsService.getByUsername(username);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/get_by_id")
    public CommonResult<UmsUser> getById(Integer id) {
        return ds2ManagerUserDetailsService.getById(id);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/update_user_info")
    public CommonResult<UmsUser> updateUserInfo(@RequestBody UmsUser user) {
        return ds2ManagerUserDetailsService.updateUserInfo(user);
    }
}

