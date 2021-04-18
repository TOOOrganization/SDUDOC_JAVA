package cn.edu.sdu.controller;

import cn.edu.sdu.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    ImgService service;

    @RequestMapping(value = "/get_latest_id", method = RequestMethod.POST)
    public Long getLatestId() {
        return service.getLatestId();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(String base64, String filename) {
        return service.save(base64, filename);
    }

    @RequestMapping(value = "/get_url_base64", method = RequestMethod.GET)
    public String getUrlBase64(Integer id) {
        return service.getUrlBase64(id);
    }
}
