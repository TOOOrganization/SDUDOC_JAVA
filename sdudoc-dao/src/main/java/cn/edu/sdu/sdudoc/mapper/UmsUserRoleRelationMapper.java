package cn.edu.sdu.sdudoc.mapper;

import cn.edu.sdu.sdudoc.entity.UmsUserRoleRelation;
import cn.edu.sdu.sdudoc.entity.UmsUserRoleRelationExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserRoleRelationMapper {
    long countByExample(UmsUserRoleRelationExample example);

    int deleteByExample(UmsUserRoleRelationExample example);

    int deleteByPrimaryKey(Integer urid);

    int insert(UmsUserRoleRelation record);

    int insertSelective(UmsUserRoleRelation record);

    List<UmsUserRoleRelation> selectByExample(UmsUserRoleRelationExample example);

    UmsUserRoleRelation selectByPrimaryKey(Integer urid);

    int updateByExampleSelective(@Param("record") UmsUserRoleRelation record, @Param("example") UmsUserRoleRelationExample example);

    int updateByExample(@Param("record") UmsUserRoleRelation record, @Param("example") UmsUserRoleRelationExample example);

    int updateByPrimaryKeySelective(UmsUserRoleRelation record);

    int updateByPrimaryKey(UmsUserRoleRelation record);
}