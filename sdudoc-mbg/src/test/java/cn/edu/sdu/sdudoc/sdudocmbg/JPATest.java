package cn.edu.sdu.sdudoc.sdudocmbg;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
import org.hibernate.criterion.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


}