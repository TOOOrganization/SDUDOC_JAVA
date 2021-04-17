package cn.edu.sdu.sdudoc.sdudocmysql;

import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SQLTest {

    @Autowired
    UmsUserMapper mapper;
    @Test
    public void select() {
        System.out.println(mapper.selectByPrimaryKey("1"));
    }
}
