package cn.edu.sdu.sdudoc.sdudocmysql;

import cn.edu.sdu.sdudoc.sdudocmysql.service.ImgService;
import cn.edu.sdu.sdudoc.sdudocmysql.service.impl.ImgServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class SQLTest {

    @Autowired
    private ImgService service;

    @Test
    public void select() {
        System.out.println(Arrays.toString(service.getImgBase64("E:\\media\\picture\\4c0d4e2f68a04f463605a5b695baf7e8.jpeg")));
    }

}
