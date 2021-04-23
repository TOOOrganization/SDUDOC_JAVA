package cn.edu.sdu.service;

public interface ImgService {

    public Long getLatestId();
    public String save(String base64, String filename);
    public Long save(byte[] data);
    public String getImgBase64ById(Long id);
    public byte[] getImgBase64(String url);
}
