package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Img;

import java.io.IOException;

public interface ImgService {

    public Long getLatestId();
    public String save(String base64, String filename);
    public Long save(byte[] data);
    public String getImgBase64ById(Long id);
    public byte[] getImgBase64(String url);
    public Img fileChecksumExist(String checksum) throws IOException;
}
