package cn.edu.sdu.service.impl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Img;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ImgRepository;
import cn.edu.sdu.service.ImgService;
import cn.edu.sdu.util.Base64Util;
import cn.edu.sdu.util.RandomPicNameUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Base64Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    ImgRepository repository;

    @Override
    public Long getLatestId() {
        Img img = new Img();
        img.setId(1);
        return repository.count(Example.of(img));
    }

    @Override
    public String save(String base64, String filename) {
        String[] d = base64.split("base64,");

        if (d != null && d.length == 2) {
//            String prefix = d[0];
            String data = d[1];

            byte[] bs = Base64Util.base64Decode(data).getBytes(StandardCharsets.UTF_8);
            for(int i = 0 ; i < bs.length; ++i) {
                if(bs[i] < 0) {
                    //调整异常数据
                    bs[i] += 256;
                }
            }

            // 生成图片存储路径
            String randomName = RandomPicNameUtil.getRandomName(filename);

            String imgFilePath = System.getProperty("user.dir");
            imgFilePath = imgFilePath + "/webapps/assets/picture/" + randomName;

            // 写入数据库
            Img img = new Img();
            img.setUrl(imgFilePath);
            repository.save(img);

            // 写入file
            try {
                OutputStream out = new FileOutputStream(imgFilePath);
                out.write(bs);
                out.flush();
                out.close();
            } catch (IOException e) {
                return "图片上传失败";
            }
        } else {
            return "图片格式不正确";
        }
        return "图片上传服务暂不可用";
    }

    @Override
    public String getUrlBase64(Integer id) {
        Optional<Img> op = repository.findById(id);
        if (op.isPresent()) {
            Img img = op.get();

            // 读取图片
            try {
                InputStream in = new FileInputStream(img.getUrl());
                byte[] data = new byte[in.available()];
                in.read(data);
                in.close();

                return Base64Util.base64Encode(new String(data));
            } catch (IOException e) {
                return "图片读取失败";
            }
        } else {
            return "找不到图片";
        }
    }

    public static void main(String[] args) {
        String imgFilePath = System.getProperty("user.dir");
        System.out.println(imgFilePath);
    }
}
