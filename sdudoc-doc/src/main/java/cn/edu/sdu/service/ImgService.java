package cn.edu.sdu.service;

import java.util.Base64;

public interface ImgService {
    public Integer getLatestId();
    public String save(Base64 base64);
    public Base64 getUrlBase64(Integer id);
}
