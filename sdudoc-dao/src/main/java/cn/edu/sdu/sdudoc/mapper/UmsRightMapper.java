package cn.edu.sdu.sdudoc.mapper;

import cn.edu.sdu.sdudoc.entity.UmsRight;
import cn.edu.sdu.sdudoc.entity.UmsRightExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRightMapper {
    long countByExample(UmsRightExample example);

    int deleteByExample(UmsRightExample example);

    int deleteByPrimaryKey(Integer rightId);

    int insert(UmsRight record);

    int insertSelective(UmsRight record);

    List<UmsRight> selectByExample(UmsRightExample example);

    UmsRight selectByPrimaryKey(Integer rightId);

    int updateByExampleSelective(@Param("record") UmsRight record, @Param("example") UmsRightExample example);

    int updateByExample(@Param("record") UmsRight record, @Param("example") UmsRightExample example);

    int updateByPrimaryKeySelective(UmsRight record);

    int updateByPrimaryKey(UmsRight record);
}