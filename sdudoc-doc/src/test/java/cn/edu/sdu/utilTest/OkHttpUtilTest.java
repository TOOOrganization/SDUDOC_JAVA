package cn.edu.sdu.utilTest;

import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.util.OkHttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OkHttpUtilTest {

    @Test
    public void doGet() {
        try {
            System.out.println(OkHttpUtil.doGet("http://www.baidu.com", "GET"));
        } catch (HttpStatusException e) {
            e.printStackTrace();
        }
    }
}
