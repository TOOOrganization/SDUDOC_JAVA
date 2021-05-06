package cn.edu.sdu.sdudoc.sdudocmbg;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class JPATest {

    @Autowired
    private UmsUserRepository umsUserRepository;
    @Test
    public void select() {
        System.out.println(umsUserRepository.findAll());

    }

    @Test
    public void delete() {
        UmsUser u = new UmsUser();
        u.setPassword("333");
        System.out.println(u);
        umsUserRepository.delete(u);

    }
    @Autowired
    UmsUserRepository repository;

    @Test
    public void getLogin() {
        Optional<UmsUser> user = repository.findById(1);
//        JSONObject result = (JSONObject) login.login(user);
//        System.out.println(result.get("token"));
        System.out.println(user.get().getPassword());
//        System.out.println(hello.hello());
    }


}