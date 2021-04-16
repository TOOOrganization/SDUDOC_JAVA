package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRoleRightRelation;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRoleRightRelationExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsRoleRightRelationMapper;

import java.util.List;

public interface UmsRoleRightRelationService extends UmsRoleRightRelationMapper {
    @Override
    long countByExample(UmsRoleRightRelationExample example);

    @Override
    int deleteByExample(UmsRoleRightRelationExample example);

    @Override
    int deleteByPrimaryKey(Integer rrid);

    @Override
    int insert(UmsRoleRightRelation record);

    @Override
    int insertSelective(UmsRoleRightRelation record);

    @Override
    List<UmsRoleRightRelation> selectByExample(UmsRoleRightRelationExample example);

    @Override
    UmsRoleRightRelation selectByPrimaryKey(Integer rrid);

    @Override
    int updateByExampleSelective(UmsRoleRightRelation record, UmsRoleRightRelationExample example);

    @Override
    int updateByExample(UmsRoleRightRelation record, UmsRoleRightRelationExample example);

    @Override
    int updateByPrimaryKeySelective(UmsRoleRightRelation record);

    @Override
    int updateByPrimaryKey(UmsRoleRightRelation record);
}
