package cn.edu.sdu.service;

import java.util.Base64;

public interface ImgService {

    public Long getLatestId();
    public String save(String base64, String filename);
    public String getUrlBase64(Integer id);

}
