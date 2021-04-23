package cn.edu.sdu.controller;

import cn.edu.sdu.service.ImgService;
import cn.edu.sdu.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/img")
public class ImgServiceController {

    @Autowired
    ImgService service;

    @RequestMapping(value = "/get_latest_id", method = RequestMethod.POST)
    public Long getLatestNewId() {
        return service.getLatestId() + 1;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(String base64, String filename) {
        return service.save(base64.replaceAll(" ", "+"), filename);
    }

    @RequestMapping(value = "/get_url_base64", method = RequestMethod.GET)
    public String getImgBase64FromUrl(Long id) {
        return service.getImgBase64ById(id);
    }

    @RequestMapping(value = "/get_img_url", method = RequestMethod.GET)
    public void getImg(HttpServletResponse response, String url) {
        byte[] buffer = Base64Util.base64Decode2Bytes(service.getImgBase64("/usr/local/apache-tomcat-8.5.64/bin/webapps/assets/picture/" + url));
        OutputStream os = null;
        try {
            os = response.getOutputStream();

            os.write(buffer);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
