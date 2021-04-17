package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.entity.Img;
import cn.edu.sdu.sdudoc.entity.ImgExample;
import cn.edu.sdu.sdudoc.mapper.ImgMapper;

import java.util.List;

public interface ImgService extends ImgMapper {
    @Override
    long countByExample(ImgExample example);

    @Override
    int deleteByExample(ImgExample example);

    @Override
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(Img record);

    @Override
    int insertSelective(Img record);

    @Override
    List<Img> selectByExample(ImgExample example);

    @Override
    Img selectByPrimaryKey(Integer id);

    @Override
    int updateByExampleSelective(Img record, ImgExample example);

    @Override
    int updateByExample(Img record, ImgExample example);

    @Override
    int updateByPrimaryKeySelective(Img record);

    @Override
    int updateByPrimaryKey(Img record);
}
