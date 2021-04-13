package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserMapper;

import java.util.List;

public interface UmsUserService extends UmsUserMapper {
    @Override
    long countByExample(UmsUserExample example);

    @Override
    int deleteByExample(UmsUserExample example);

    @Override
    int deleteByPrimaryKey(String uid);

    @Override
    int insert(UmsUser record);

    @Override
    int insertSelective(UmsUser record);

    @Override
    List<UmsUser> selectByExample(UmsUserExample example);

    @Override
    UmsUser selectByPrimaryKey(String uid);

    @Override
    int updateByExampleSelective(UmsUser record, UmsUserExample example);

    @Override
    int updateByExample(UmsUser record, UmsUserExample example);

    @Override
    int updateByPrimaryKeySelective(UmsUser record);

    @Override
    int updateByPrimaryKey(UmsUser record);
}
