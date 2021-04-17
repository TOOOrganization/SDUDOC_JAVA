package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.entity.Img;
import cn.edu.sdu.sdudoc.entity.ImgExample;
import cn.edu.sdu.sdudoc.mapper.ImgMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    ImgMapper imgMapper;

    @Override
    public long countByExample(ImgExample example) {
        return imgMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ImgExample example) {
        return imgMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return imgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Img record) {
        return imgMapper.insert(record);
    }

    @Override
    public int insertSelective(Img record) {
        return imgMapper.insertSelective(record);
    }

    @Override
    public List<Img> selectByExample(ImgExample example) {
        return imgMapper.selectByExample(example);
    }

    @Override
    public Img selectByPrimaryKey(Integer id) {
        return imgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Img record, ImgExample example) {
        return imgMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Img record, ImgExample example) {
        return imgMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Img record) {
        return imgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Img record) {
        return imgMapper.updateByPrimaryKey(record);
    }
}
