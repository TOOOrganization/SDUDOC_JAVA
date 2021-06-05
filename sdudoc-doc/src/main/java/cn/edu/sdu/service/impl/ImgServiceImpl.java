package cn.edu.sdu.service.impl;

import cn.edu.sdu.entity.ds1.Img;
import cn.edu.sdu.repository.ds1.ImgRepository;
import cn.edu.sdu.service.ImgService;
import cn.edu.sdu.util.Base64Util;
import cn.edu.sdu.util.FileChecksum;
import cn.edu.sdu.util.RandomPicNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    ImgRepository repository;

    @Override
    public Long getLatestId() {
        Img img = new Img();
        return repository.count(Example.of(img));
    }

    @Override
    public String save(String base64, String filename) {
        String[] d = base64.split("base64,");

        if (d.length == 2) {
//            String prefix = d[0];
            String data = d[1];

            byte[] bs = Base64Util.base64Decode2Bytes(data);
            for(int i = 0 ; i < bs.length; ++i) {
                if(bs[i] < 0) {
                    //调整异常数据
                    bs[i] += 256;
                }
            }

            // 生成图片存储路径
            String randomName = RandomPicNameUtil.getRandomName(filename);

            String imgFilePath = System.getProperty("user.dir");
            File dir = new File(imgFilePath + "/webapps/assets/picture/");
            if (!dir.exists() && !dir.mkdirs()) {
                return "生成图片存储路径失败";
            }

            imgFilePath = imgFilePath + "/webapps/assets/picture/" + randomName;

            // 比对校验和，如果数据库里没有，则写入数据库
            try {
                String checksum = FileChecksum.checksumSHA256(bs);
                Img img;
                if ((img = fileChecksumExist(checksum)) == null) {
                    img = new Img();
                    img.setId(getLatestId() + 1L);
                    img.setUrl(imgFilePath);
                    img.setSha256(checksum);
                    repository.save(img);

                    // 写入file
                    OutputStream out = new FileOutputStream(imgFilePath);
                    out.write(bs);
                    out.flush();
                    out.close();

                    return randomName;
                } else {
                    // 数据库里有，则返回图片地址
                    String url = img.getUrl();
                    randomName = url.substring(url.lastIndexOf('/'));
                    return randomName;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "图片上传失败";
            }
        } else {
            return "图片格式不正确";
        }
    }

    @Override
    public Long save(byte[] data) {
        return null;
    }

    @Override
    public String getImgBase64ById(Long id) {
        Optional<Img> op = repository.findById(id);
        if (op.isPresent()) {
            Img img = op.get();

            // 读取图片
            return new String(getImgBase64(img.getUrl()));
        } else {
            return "找不到图片";
        }
    }

    public byte[] getImgBase64(String url) {
        try {
            InputStream in = new FileInputStream(url);
            byte[] data = new byte[in.available()];

            int n;
            while ((n = in.read(data)) == -1) break;

            in.close();

            return Base64Util.base64Encode2Bytes(data);
        } catch (IOException e) {
            e.printStackTrace();
            return "图片读取失败".getBytes(StandardCharsets.UTF_8);
        }
    }

    /**
     * 返回校验和是否存在
     * 存在返回Img，不存在返回null
     * */
    @Override
    public Img fileChecksumExist(String checksum) {
        Img img = new Img();
        img.setSha256(checksum);
        Optional<Img> one = repository.findOne(Example.of(img));

        return one.orElse(null);
    }

    public static void main(String[] args) {
        String imgFilePath = System.getProperty("user.dir");
        File dir = new File(imgFilePath + "\\webapps\\assets\\picture\\");
        System.out.println(dir.getPath());
        if (!dir.exists()) {
            System.out.println(dir.mkdirs());
        }
    }
}
