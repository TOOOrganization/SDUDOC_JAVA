package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserRoleRelation;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserRoleRelationExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserRoleRelationMapper;

import java.util.List;

public interface UmsUserRoleRelationService extends UmsUserRoleRelationMapper {
    @Override
    long countByExample(UmsUserRoleRelationExample example);

    @Override
    int deleteByExample(UmsUserRoleRelationExample example);

    @Override
    int deleteByPrimaryKey(Integer urid);

    @Override
    int insert(UmsUserRoleRelation record);

    @Override
    int insertSelective(UmsUserRoleRelation record);

    @Override
    List<UmsUserRoleRelation> selectByExample(UmsUserRoleRelationExample example);

    @Override
    UmsUserRoleRelation selectByPrimaryKey(Integer urid);

    @Override
    int updateByExampleSelective(UmsUserRoleRelation record, UmsUserRoleRelationExample example);

    @Override
    int updateByExample(UmsUserRoleRelation record, UmsUserRoleRelationExample example);

    @Override
    int updateByPrimaryKeySelective(UmsUserRoleRelation record);

    @Override
    int updateByPrimaryKey(UmsUserRoleRelation record);
}
