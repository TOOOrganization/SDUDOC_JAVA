package cn.edu.sdu.controller;

import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.service.ImgService;
import cn.edu.sdu.util.Base64Util;
import cn.edu.sdu.util.OkHttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/img")
public class ImgServiceController {

    @Autowired
    ImgService service;

    @RequestMapping(value = "/get_latest_id", method = RequestMethod.POST)
    public Long getLatestNewId() {
        return service.getLatestId() + 1;
    }

    @RequestMapping(value = "/save_by_base64", method = RequestMethod.POST, produces = "application/json")
    public Long save(@RequestBody JSONObject data) {
        Map<String, String> map = new HashMap<>();
        map.put("data", data.toJSONString());

        String response;
        try {
            response = OkHttpUtil.doPost("http://211.87.232.199:8080/mysql/img/save_by_base64", data.toJSONString(), null, "POST");
        } catch (HttpStatusException e) {
            e.printStackTrace();
            response = "-5";
        }
        return Long.valueOf(response);
    }

    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    public void getImgById(HttpServletResponse response, Long id) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();

            String base64;
            base64 = OkHttpUtil.doGet("http://211.87.232.199:8080/mysql/img/get_by_id?id=" + id, "GET");

            byte[] buffer = Base64Util.base64Decode2Bytes(base64);
            os.write(buffer);
            os.flush();

        } catch (IOException | HttpStatusException e) {
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

    @RequestMapping(value = "/get_by_url", method = RequestMethod.GET)
    public void getImgByUrl(HttpServletResponse response, String url) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();

            String base64;
            base64 = OkHttpUtil.doGet("http://211.87.232.199:8080/mysql/img/get_by_url?url=" + url, "GET");

            byte[] buffer = Base64Util.base64Decode2Bytes(base64);
            os.write(buffer);
            os.flush();

        } catch (IOException | HttpStatusException e) {
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
