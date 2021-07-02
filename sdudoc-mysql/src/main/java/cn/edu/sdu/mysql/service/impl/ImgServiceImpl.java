package cn.edu.sdu.mysql.service.impl;

import cn.edu.sdu.entity.ds1.Img;
import cn.edu.sdu.mysql.service.ImgService;
import cn.edu.sdu.common.util.FileChecksum;
import cn.edu.sdu.common.util.RandomPicNameUtil;
import cn.edu.sdu.repository.ds1.ImgRepository;
import cn.edu.sdu.common.util.Base64Util;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class ImgServiceImpl implements ImgService {

    final ImgRepository repository;

    public ImgServiceImpl(ImgRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long getLatestId() {
        Img img = new Img();
        return repository.count(Example.of(img));
    }

    @Override
    public Long save(String base64, String filename) {
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

            String imgFilePath = generateImgUrl(filename);

            try {
                // 如果成功写入文件，记录在数据库里
                if (writeInFileByData(bs, imgFilePath)) {
                    // 比对校验和，如果数据库里没有，则写入数据库
                    String checksum = FileChecksum.checksumSHA256(bs);
                    Img img;
                    if ((img = fileChecksumExist(checksum)) == null) {
                        img = new Img();
                        img.setId(getLatestId() + 1L);
                        img.setUrl(imgFilePath);
                        img.setSha256(checksum);
                        repository.save(img);
                        return img.getId();
                    }
                    else {
                        // 数据库里有，则返回图片id
                        return img.getId();
//                        return randomName;
                    }
                } else {
                    return -4L;  // 写入文件失败
                }
            } catch (IOException e) {
                return -2L;
            }
        } else {
            return -3L;
//            return "图片格式不正确";
        }
    }

    @Override
    public Long save(byte[] data) {
        return null;
    }

    public boolean writeInFileByData(byte[] data, String imgFilePath) {
        boolean result = false;

        // 写入file
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            out.write(data);
            out.flush();
            out.close();

            result = true;
        } catch (IOException e) {
//            return -2L;
//            return "图片上传失败";
        }

        return result;
    }

    public String generateImgUrl(String filename) {
        // 生成图片存储路径
        String randomName = RandomPicNameUtil.getRandomName(filename);

        String imgFilePath = System.getProperty("user.dir");
        char separator = '/';
        if (imgFilePath.indexOf('/') < 0) {
            separator = '\\';
        }
        String dirName = separator + "webapps"
                + separator + "assets"
                + separator + "picture"
                + separator;
        File dir = new File(imgFilePath + dirName);
        if (!dir.exists() && !dir.mkdirs()) {
//            return -1L;
//            return "生成图片存储路径失败";
            return null;
        }

        imgFilePath = imgFilePath + dirName + randomName;

        return imgFilePath;
    }

    @Override
    public byte[] getImgById(Long id) {
        Optional<Img> op = repository.findById(id);
        if (op.isPresent()) {
            Img img = op.get();

            // 读取图片
            return getImgByUrl(img.getUrl());
        } else {
            return "找不到图片".getBytes(StandardCharsets.UTF_8);
        }
    }

    public byte[] getImgByUrl(String url) {
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
