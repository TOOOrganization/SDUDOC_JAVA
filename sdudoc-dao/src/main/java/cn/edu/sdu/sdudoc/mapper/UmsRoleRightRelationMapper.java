package cn.edu.sdu.sdudoc.mapper;

import cn.edu.sdu.sdudoc.entity.UmsRoleRightRelation;
import cn.edu.sdu.sdudoc.entity.UmsRoleRightRelationExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRoleRightRelationMapper {
    long countByExample(UmsRoleRightRelationExample example);

    int deleteByExample(UmsRoleRightRelationExample example);

    int deleteByPrimaryKey(Integer rrid);

    int insert(UmsRoleRightRelation record);

    int insertSelective(UmsRoleRightRelation record);

    List<UmsRoleRightRelation> selectByExample(UmsRoleRightRelationExample example);

    UmsRoleRightRelation selectByPrimaryKey(Integer rrid);

    int updateByExampleSelective(@Param("record") UmsRoleRightRelation record, @Param("example") UmsRoleRightRelationExample example);

    int updateByExample(@Param("record") UmsRoleRightRelation record, @Param("example") UmsRoleRightRelationExample example);

    int updateByPrimaryKeySelective(UmsRoleRightRelation record);

    int updateByPrimaryKey(UmsRoleRightRelation record);
}