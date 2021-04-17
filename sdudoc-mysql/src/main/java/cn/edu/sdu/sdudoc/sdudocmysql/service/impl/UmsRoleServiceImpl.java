package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.entity.UmsRole;
import cn.edu.sdu.sdudoc.entity.UmsRoleExample;
import cn.edu.sdu.sdudoc.mapper.UmsRoleMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    UmsRoleMapper umsRoleMapper;

    @Override
    public long countByExample(UmsRoleExample example) {
        return umsRoleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsRoleExample example) {
        return umsRoleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return umsRoleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(UmsRole record) {
        return umsRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsRole record) {
        return umsRoleMapper.insertSelective(record);
    }

    @Override
    public List<UmsRole> selectByExample(UmsRoleExample example) {
        return umsRoleMapper.selectByExample(example);
    }

    @Override
    public UmsRole selectByPrimaryKey(Integer rid) {
        return umsRoleMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByExampleSelective(UmsRole record, UmsRoleExample example) {
        return umsRoleMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UmsRole record, UmsRoleExample example) {
        return umsRoleMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRole record) {
        return umsRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsRole record) {
        return umsRoleMapper.updateByPrimaryKey(record);
    }
}
