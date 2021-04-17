package cn.edu.sdu.sdudoc.sdudocmbg.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUserExample;

import java.util.List;

public interface UmsUserService{

    long countByExample();

    void deleteByExample(UmsUser example);

    void deleteById(String uid);

    UmsUser save(UmsUser record);

    void saveAll(List<UmsUser> record);

    void flush();

    List<UmsUser> selectByExample(UmsUserExample example);

    List<UmsUser> findByUid(String uid);

    int updateByExampleSelective(UmsUser record, UmsUserExample example);

    int updateByExample(UmsUser record, UmsUserExample example);

    int updateByPrimaryKeySelective(UmsUser record);

    int updateByPrimaryKey(UmsUser record);
}