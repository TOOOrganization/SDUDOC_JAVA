package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.repository.UmsUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SQLTest {

    @Autowired
    private UmsUserRepository umsUserRepository;
    @Test
    public void select() {
        System.out.println(umsUserRepository.findAll());
    }

}
