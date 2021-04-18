package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.annonations.UserLoginToken;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.service.TokenService;
import cn.edu.sdu.service.UmsUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object login(@RequestBody UmsUser user) {
        JSONObject jsonObject = new JSONObject();
        Optional<UmsUser> userForBase = service.findById(user.getUid());
        if (userForBase.isPresent()) {
            if (!userForBase.get().getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败，密码错误");
            } else {
                String token = tokenService.getToken(userForBase.get());
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
            }
            return jsonObject;
        }else{
            jsonObject.put("message", "登录失败，用户不存在");
            return jsonObject;
        }
    }

    @UserLoginToken
    @GetMapping("/get_message")
    public String getMessage() {
        return "通过验证";
    }
}
