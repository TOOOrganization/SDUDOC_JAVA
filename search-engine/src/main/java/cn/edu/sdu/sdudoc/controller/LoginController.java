package cn.edu.sdu.sdudoc.controller;

import cn.edu.sdu.sdudoc.annonations.UserLoginToken;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2.UmsUserRepository;
import cn.edu.sdu.sdudoc.service.TokenService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/set_password")
    public String setPassword(String username, String password, String confirmPassword) {
        if (password == null || password.equals("") || confirmPassword == null || confirmPassword.equals("")) {
            return "密码不能为空";
        }
        if (!password.equals(confirmPassword)) {
            return "两次输入密码不同";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));
        if (one.isPresent()) {
            if (one.get().getPassword().equals(password)) {
                return "密码重复";
            } else {
                user = one.get();
                user.setPassword(password);
                service.save(user);
                return password;
            }
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_nickname")
    public String setNickname(String username, String nickname) {
        if (nickname == null || nickname.equals("")) {
            return "昵称不能为空";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setNickname(nickname);
            service.save(user);
            return nickname;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_email")
    public String setEmail(String username, String email) {
        if (email == null || email.equals("")) {
            return "邮箱不能为空";
        }
        if (email.indexOf('@') == -1) {
            return "邮箱地址格式错误";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setEmail(email);
            service.save(user);
            return email;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_phone")
    public String setPhone(String username, String phone) {
        if (phone == null || phone.equals("")) {
            return "手机号码不能为空";
        }
        if (phone.trim().length() != 11) {
            return "号码格式不正确";
        }
        if (phone.charAt(0) != '1' || (phone.charAt(0) == '1' && "358".indexOf(phone.charAt(1)) == -1)) {
            return "号码格式不正确";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setPhone(new BigInteger(phone));
            service.save(user);
            return phone;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_sex")
    public Integer setSex(String username, Integer sex) {
        if (sex == null) {
            return -1;  // 参数为空
        }
        if (sex != 0 && sex != 1) {
            return -2;  // 参数不合法
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setSex(sex);
            service.save(user);
            return sex;
        } else {
            return -3;  // 用户不存在
        }
    }

    @PostMapping("/set_birthday")
    public String setBirthday(String username, String birthday) {
        if (birthday == null || birthday.equals("")) {
            return "生日不能为空";
        }
        if (birthday.length() != 10
                || birthday.indexOf('-') == -1
                || !birthday.substring(0, 4).matches("[0-9]*")
                || !birthday.substring(5, 7).matches("[0-9]*")
                || !birthday.substring(8).matches("[0-9]*")) {
            return "生日格式应为 yyyy-MM-dd";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setBirthday(birthday);
            service.save(user);
            return birthday;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping(value = "/set_avatar", produces = "application/json")
    public String setAvatar(@RequestBody JSONObject data) {
        String username = data.getString("username");
        String img = data.getString("img");
        if (!img.isEmpty()) {
            try {
                String imgFilePath = System.getProperty("user.dir");
                File dir = new File(imgFilePath + "/userimg/picture/");
                if (!dir.exists() && !dir.mkdirs()) {
                    return "生成图片存储路径失败";
                }

                UmsUser user = new UmsUser();
                user.setUsername(username);
                Optional<UmsUser> one = service.findOne(Example.of(user));
                if (!one.isPresent()) {
                    return "用户不存在";
                } else {
                    user = one.get();
                    imgFilePath += "/userimg/picture/" + one.get().getUsername() + ".jpg";
                    user.setImgurl(imgFilePath);

                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(imgFilePath));
                    out.write(img.getBytes());
                    out.flush();
                    out.close();

                    service.save(user);

                    return "图片写入成功";
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "图片写入失败";
            }
        } else {
            return "图片为空";
        }
    }

    @GetMapping("/get_avatar")
    public void getAvatar(HttpServletResponse response, String username) {
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = service.findOne(Example.of(user));

        if (one.isPresent()) {
            try {
                ServletOutputStream out = response.getOutputStream();

                InputStream in = new FileInputStream(System.getProperty("user.dir") + "/userimg/picture/" + username + ".jpg");
                byte[] data = new byte[in.available()];

                while (in.read(data) == -1) break;

                in.close();

                out.write(data);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

