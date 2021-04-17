package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserRoleRelation;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUserRoleRelationExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsUserRoleRelationMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.UmsUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsUserRoleRelationServiceImpl implements UmsUserRoleRelationService {

    @Autowired
    UmsUserRoleRelationMapper umsUserRoleRelationMapper;

    @Override
    public long countByExample(UmsUserRoleRelationExample example) {
        return umsUserRoleRelationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsUserRoleRelationExample example) {
        return umsUserRoleRelationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer urid) {
        return umsUserRoleRelationMapper.deleteByPrimaryKey(urid);
    }

    @Override
    public int insert(UmsUserRoleRelation record) {
        return umsUserRoleRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsUserRoleRelation record) {
        return umsUserRoleRelationMapper.insertSelective(record);
    }

    @Override
    public List<UmsUserRoleRelation> selectByExample(UmsUserRoleRelationExample example) {
        return umsUserRoleRelationMapper.selectByExample(example);
    }

    @Override
    public UmsUserRoleRelation selectByPrimaryKey(Integer urid) {
        return umsUserRoleRelationMapper.selectByPrimaryKey(urid);
    }

    @Override
    public int updateByExampleSelective(UmsUserRoleRelation record, UmsUserRoleRelationExample example) {
        return umsUserRoleRelationMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UmsUserRoleRelation record, UmsUserRoleRelationExample example) {
        return umsUserRoleRelationMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsUserRoleRelation record) {
        return umsUserRoleRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsUserRoleRelation record) {
        return umsUserRoleRelationMapper.updateByPrimaryKey(record);
    }
}
