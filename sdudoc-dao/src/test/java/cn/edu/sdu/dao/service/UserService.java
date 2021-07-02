package cn.edu.sdu.dao.service;

import cn.edu.sdu.repository.ds1.UmsUserRepository;
import cn.edu.sdu.entity.ds1.UmsUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserService {
    @Autowired
    UmsUserRepository ds1Repository;

    @Autowired
    DataSourceService service;

    @Test
    public void findUserFromDs1() {
        List<UmsUser> list = service.findDs1();

        list.forEach(user -> System.out.print(user.getNickname() + "    "));

        System.out.println();
    }

    @Test
    public void findUserFromDs2() {
        List<UmsUser> list = service.findDs2();

        list.forEach(user -> System.out.print(user.getNickname() + "    "));

        System.out.println();
    }
}
