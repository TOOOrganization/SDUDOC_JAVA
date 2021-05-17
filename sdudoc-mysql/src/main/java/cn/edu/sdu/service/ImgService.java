package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.Img;

import java.io.IOException;

public interface ImgService {

    public Long getLatestId();
    public Long save(String base64, String filename);
    public Long save(byte[] data);
    public byte[] getImgById(Long id);
    public byte[] getImgByUrl(String url);
    public Img fileChecksumExist(String checksum) throws IOException;
}
