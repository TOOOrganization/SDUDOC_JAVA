//package cn.edu.sdu.sdudoc.sdudocdao.mapper;
//
//import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;
//import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserExample;
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//
//@Mapper
//public interface UmsUserMapper {
//    long countByExample(UmsUserExample example);
//
//    int deleteByExample(UmsUserExample example);
//
//    int deleteByPrimaryKey(String uid);
//
//    int insert(UmsUser record);
//
//    int insertSelective(UmsUser record);
//
//    List<UmsUser> selectByExample(UmsUserExample example);
//
//    UmsUser selectByPrimaryKey(String uid);
//
//    int updateByExampleSelective(@Param("record") UmsUser record, @Param("example") UmsUserExample example);
//
//    int updateByExample(@Param("record") UmsUser record, @Param("example") UmsUserExample example);
//
//    int updateByPrimaryKeySelective(UmsUser record);
//
//    int updateByPrimaryKey(UmsUser record);
//}