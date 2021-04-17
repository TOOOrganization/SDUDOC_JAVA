package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.entity.UmsRole;
import cn.edu.sdu.sdudoc.entity.UmsRoleExample;
import cn.edu.sdu.sdudoc.mapper.UmsRoleMapper;

import java.util.List;

public interface UmsRoleService extends UmsRoleMapper {
    @Override
    long countByExample(UmsRoleExample example);

    @Override
    int deleteByExample(UmsRoleExample example);

    @Override
    int deleteByPrimaryKey(Integer rid);

    @Override
    int insert(UmsRole record);

    @Override
    int insertSelective(UmsRole record);

    @Override
    List<UmsRole> selectByExample(UmsRoleExample example);

    @Override
    UmsRole selectByPrimaryKey(Integer rid);

    @Override
    int updateByExampleSelective(UmsRole record, UmsRoleExample example);

    @Override
    int updateByExample(UmsRole record, UmsRoleExample example);

    @Override
    int updateByPrimaryKeySelective(UmsRole record);

    @Override
    int updateByPrimaryKey(UmsRole record);
}
