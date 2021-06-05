package cn.edu.sdu.controller;

import cn.edu.sdu.annonations.UserLoginToken;
import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.entity.ds1.UmsUser;
import cn.edu.sdu.service.EditorUserDetailsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    EditorUserDetailsService userDetailsService;

    @PostMapping("/login")
    public CommonResult<String> login(String username, String password) {
        return userDetailsService.login(username, password);
    }

    @PostMapping("/register")
    public CommonResult<String> register(String username, String password, String nickname) {
        return userDetailsService.register(username, password, nickname);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/set_password")
    public CommonResult<String> setPassword(String username, String password, String confirmPassword) {
        return userDetailsService.setPassword(username, password, confirmPassword);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/get_by_username")
    public CommonResult<UmsUser> getByUsername(String username) {
        return userDetailsService.getByUsername(username);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/get_by_id")
    public CommonResult<UmsUser> getById(Integer id) {
        return userDetailsService.getById(id);
    }

    @PreAuthorize("hasAnyRole('author')")
    @PostMapping("/update_user_info")
    public CommonResult<UmsUser> updateUserInfo(@RequestBody UmsUser user) {
        return userDetailsService.updateUserInfo(user);
    }
}
