package cn.edu.sdu.controller;

import cn.edu.sdu.annonations.UserLoginToken;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.service.TokenService;
import cn.edu.sdu.service.UmsUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UmsUserService service;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public JSONObject login(String username, String password) {
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
            jsonObject.put("message", "登录失败，用户不存在或密码错误");
        }

        return jsonObject;
    }

    @PostMapping("/register")
    public Object register(String username, String password, String nickname) {
        JSONObject jsonObject = new JSONObject();
        UmsUser fuser = new UmsUser();
        fuser.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(fuser));

        if (one.isPresent()) {
            jsonObject.put("message", "用户已存在");
        } else {
            fuser.setPassword(password);
            fuser.setNickname(nickname);
            fuser.setStatus(1);
            fuser.setCount(1);

            service.save(fuser);
            jsonObject = login(username, password);
        }

        return jsonObject;
    }

    @UserLoginToken
    @GetMapping("/get_message")
    public String getMessage() {
        return "通过验证";
    }
}
