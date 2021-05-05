//package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;
//
//import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;
//import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserExample;
//import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserMapper;
//import cn.edu.sdu.sdudoc.sdudocmysql.service.UmsUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UmsUserServiceImpl implements UmsUserService {
//
//    @Autowired
//    UmsUserMapper umsUserMapper;
//
//    @Override
//    public long countByExample(UmsUserExample example) {
//        return umsUserMapper.countByExample(example);
//    }
//
//    @Override
//    public int deleteByExample(UmsUserExample example) {
//        return umsUserMapper.deleteByExample(example);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(String uid) {
//        return umsUserMapper.deleteByPrimaryKey(uid);
//    }
//
//    @Override
//    public int insert(UmsUser record) {
//        return umsUserMapper.insert(record);
//    }
//
//    @Override
//    public int insertSelective(UmsUser record) {
//        return umsUserMapper.insertSelective(record);
//    }
//
//    @Override
//    public List<UmsUser> selectByExample(UmsUserExample example) {
//        return umsUserMapper.selectByExample(example);
//    }
//
//    @Override
//    public UmsUser selectByPrimaryKey(String uid) {
//        return umsUserMapper.selectByPrimaryKey(uid);
//    }
//
//    @Override
//    public int updateByExampleSelective(UmsUser record, UmsUserExample example) {
//        return umsUserMapper.updateByExampleSelective(record, example);
//    }
//
//    @Override
//    public int updateByExample(UmsUser record, UmsUserExample example) {
//        return umsUserMapper.updateByExample(record, example);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(UmsUser record) {
//        return umsUserMapper.updateByPrimaryKeySelective(record);
//    }
//
//    @Override
//    public int updateByPrimaryKey(UmsUser record) {
//        return umsUserMapper.updateByPrimaryKey(record);
//    }
//}
