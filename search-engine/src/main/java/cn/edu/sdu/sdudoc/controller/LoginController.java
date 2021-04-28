package cn.edu.sdu.sdudoc.controller;

import cn.edu.sdu.sdudoc.annonations.UserLoginToken;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.service.TokenService;
import cn.edu.sdu.sdudoc.service.UmsUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UmsUserService service;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public Object login(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        UmsUser user = new UmsUser();
        user.setUsername(username);
        user.setPassword(password);

        Optional<UmsUser> userForBase = service.findOne(Example.of(user));

        if (userForBase.isPresent()) {
            if (!userForBase.get().getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败，密码错误");
            } else {
                String token = tokenService.getToken(userForBase.get());
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
            }
        }else{
            jsonObject.put("message", "登录失败，用户不存在");
        }

        return jsonObject;
    }

    @PostMapping("/register")
    public Object register(String username, String password, String nickname) {
        UmsUser user = new UmsUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setStatus(1);
        user.setCount(1);

        service.save(user);
        return login(username, password);
    }

    @UserLoginToken
    @GetMapping("/get_message")
    public String getMessage() {
        return "通过验证";
    }
}
