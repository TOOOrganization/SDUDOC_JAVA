package cn.edu.sdu.sdudoc;


import cn.edu.sdu.sdudoc.sdudocmysql.SdudocMysqlApplication;
import cn.edu.sdu.sdudoc.sdudocmysql.controller.ImgServiceController;
import cn.edu.sdu.sdudoc.sdudocmysql.service.impl.ImgServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest(classes = SdudocMysqlApplication.class)
public class ImgTest {

    @Autowired
    ImgServiceController imgServiceController;

    @Autowired
    ImgServiceImpl imgService;


    @Test
    public void getHash() {
        System.out.println(Arrays.toString(imgServiceController.getImg("D:\\Tencent Files\\835778964\\FileRecv\\1.jpg")));
    }

    @Test
    public void save() {
        String url = "D:\\Tencent Files\\835778964\\FileRecv\\1.jpg";
        String base64 = "data:image/jpeg;base64," + new String(imgService.getImgBase64(url));
        String filename = "4c0d4e2f68a04f463605a5b695baf7e8.jpeg";
//
        System.out.println(imgServiceController.save(base64, filename));
//        System.out.println(base64);
    }

    @Test
    public void getImgBase64FromUrl() {

        System.out.println(imgServiceController.getImgBase64FromUrl(2L));
    }

}
