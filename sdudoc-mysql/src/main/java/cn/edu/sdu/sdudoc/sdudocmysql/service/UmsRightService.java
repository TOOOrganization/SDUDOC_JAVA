package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRight;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRightExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsRightMapper;

import java.util.List;

public interface UmsRightService extends UmsRightMapper {
    @Override
    long countByExample(UmsRightExample example);

    @Override
    int deleteByExample(UmsRightExample example);

    @Override
    int deleteByPrimaryKey(Integer rightId);

    @Override
    int insert(UmsRight record);

    @Override
    int insertSelective(UmsRight record);

    @Override
    List<UmsRight> selectByExample(UmsRightExample example);

    @Override
    UmsRight selectByPrimaryKey(Integer rightId);

    @Override
    int updateByExampleSelective(UmsRight record, UmsRightExample example);

    @Override
    int updateByExample(UmsRight record, UmsRightExample example);

    @Override
    int updateByPrimaryKeySelective(UmsRight record);

    @Override
    int updateByPrimaryKey(UmsRight record);
}
