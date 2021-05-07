package cn.edu.sdu;


import cn.edu.sdu.controller.ImgServiceController;
import cn.edu.sdu.service.impl.ImgServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ImgTest {

    @Autowired
    ImgServiceController imgServiceController;

    @Autowired
    ImgServiceImpl imgService;


    @Test
    public void getHash() {
        System.out.println(Arrays.toString(imgServiceController.getImgByUrl("E:\\media\\picture\\4c0d4e2f68a04f463605a5b695baf7e8.jpeg")));
//        System.out.println(Arrays.toString(imgService.getImgBase64("E:\\\\media\\\\picture\\\\4c0d4e2f68a04f463605a5b695baf7e8.jpeg")));
    }

    @Test
    public void save() {
        String url = "D:\\Tencent Files\\835778964\\FileRecv\\1.jpg";
        String base64 = "data:image/jpeg;base64," + new String(imgService.getImgByUrl(url));
        String filename = "4c0d4e2f68a04f463605a5b695baf7e8.jpeg";
//
        System.out.println(imgService.save(base64, filename));
//        System.out.println(base64);
    }

    @Test
    public void getImgBase64FromUrl() {

        System.out.println(Arrays.toString(imgServiceController.getImgById(2L)));
    }

}
