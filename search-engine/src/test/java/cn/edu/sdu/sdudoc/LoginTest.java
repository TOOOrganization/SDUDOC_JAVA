package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.controller.LoginController;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2.UmsUserRepository;
import com.alibaba.fastjson.JSONObject;
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
    public void getLogin() {
        JSONObject result = (JSONObject) login.login("111", "111");
        System.out.println(result);
//        Optional<UmsUser> user = repository.findById(1);
//        if (user.isPresent()) {
//            JSONObject result = (JSONObject) login.login(user.get().getUsername(), user.get().getPassword());
//            System.out.println(result.get("token"));
//            System.out.println(result);
//        }else {
//            System.out.println("sb");
//        }
//        UmsUser user = new UmsUser();
//        user.setUid("123");
//        user.setUsername("222");
//        user.setPassword("222");
//        user.setStatus(0);
//        user.setCount(0);
//        JSONObject result = (JSONObject) login.login(user);
//        System.out.println(result);
//        System.out.println(result.get("token"));
//        System.out.println(login.getMessage());

//        System.out.println(LoginController.login(user.get()));
//        System.out.println(hello.hello());
    }

    @Test
    public void register() {
        String username = "123";
        String password = "123";
        String nickname = "123";

        JSONObject object = (JSONObject) login.register(username, password, nickname);
        System.out.println(object);
    }

    @Test
    public void valueof() {
//        System.out.println("1234-".substring(0, 4).matches("[0-9]*"));
//        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void setPhone() {
        System.out.println(login.setPhone("123", "18212312345"));
    }
}
