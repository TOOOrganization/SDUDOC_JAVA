package cn.edu.sdu.controller;

import cn.edu.sdu.service.ImgService;
import cn.edu.sdu.service.impl.ImgServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImgTest {

    @Autowired
    ImgServiceController controller;
    @Autowired
    ImgServiceImpl service;

    @Test
    public void getLastId() {
        System.out.println(controller.getLatestNewId());
    }

    @Test
    public void save() {
        String url = "E:/media/picture/4c0d4e2f68a04f463605a5b695baf7e8.jpeg";
        String base64 = "data:image/jpeg;base64," + new String(service.getImgBase64(url));
        String filename = "4c0d4e2f68a04f463605a5b695baf7e8.jpeg";

        System.out.println(service.save(base64, filename));
    }

    @Test
    public void getImgBase64FromUrl() {
        System.out.println();
    }
}
