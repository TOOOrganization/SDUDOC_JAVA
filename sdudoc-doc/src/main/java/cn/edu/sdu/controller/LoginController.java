package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocdao.annonations.UserLoginToken;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserMapper;
import cn.edu.sdu.service.TokenService;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UmsUserMapper userMapper;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public Object login(@RequestBody UmsUser user) {
        JSONObject jsonObject = new JSONObject();
        UmsUser userForBase = userMapper.selectByPrimaryKey(user.getUid());

        if (userForBase == null) {
            jsonObject.put("message", "登录失败，用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败，密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/get_message")
    public String getMessage() {
        return "通过验证";
    }
}
