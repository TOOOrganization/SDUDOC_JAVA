package cn.edu.sdu.controller;

import cn.edu.sdu.util.Base64Util;
import cn.edu.sdu.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/img")
public class ImgServiceController {

    @Autowired
    ImgService service;

    @RequestMapping(value = "/get_latest_id", method = RequestMethod.POST)
    public Long getLatestNewId() {
        return service.getLatestId() + 1;
    }

    @RequestMapping(value = "/save_by_base64", method = RequestMethod.POST)
    public Long save(String base64, String filename) {
        return service.save(base64.replaceAll(" ", "+"), filename);
    }

    @RequestMapping(value = "/get_by_id", method = RequestMethod.GET)
    public byte[] getImgById(Long id) {
        return service.getImgById(id);
    }

    @RequestMapping(value = "/get_by_url", method = RequestMethod.GET)
    public byte[] getImgByUrl(String url) {
        return Base64Util.base64Decode2Bytes(service.getImgByUrl("" + url));
    }
}
