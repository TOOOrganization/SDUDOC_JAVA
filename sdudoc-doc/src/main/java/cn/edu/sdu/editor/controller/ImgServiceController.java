package cn.edu.sdu.editor.controller;

import cn.edu.sdu.editor.service.ImgService;
import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.common.api.ResultCode;
import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.common.util.OkHttpUtil;
import cn.edu.sdu.common.util.Base64Util;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/img")
public class ImgServiceController{

    @Autowired
    ImgService service;

    @PreAuthorize("hasAnyRole('administrator_editor', 'author')")
    @RequestMapping(value = "/get_latest_id", method = RequestMethod.POST)
    public CommonResult<Long> getLatestNewId() {
        Long latestId = service.getLatestId() + 1;
        return CommonResult.success(latestId);
    }

    @PreAuthorize("hasAnyRole('administrator_editor', 'author')")
    @RequestMapping(value = "/save_by_base64", method = RequestMethod.POST, produces = "application/json")
    public CommonResult<String> save(@RequestBody JSONObject data) {
        String url = "http://211.87.232.199:8080/mysql/img/save_by_base64";
        String response;
        try {
            response = OkHttpUtil.doPost(url, data.toJSONString(), null, "POST");
            return CommonResult.success(response);
        } catch (HttpStatusException e) {
            e.printStackTrace();
            return CommonResult.failed(
                    ResultCode.PICTURE_GET_FAILURE,
                    ResultCode.PICTURE_GET_FAILURE.getMessage()
            );
        }
    }

    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    public void getImgById(HttpServletResponse response, Long id) {
        OutputStream os = null;
        try {
            response.setContentType("image/png");
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
