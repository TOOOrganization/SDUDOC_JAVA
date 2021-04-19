package cn.edu.sdu.service;

public interface ImgService {

    public Long getLatestId();
    public String save(String base64, String filename);
    public String getImgBase64ById(Long id);

}
