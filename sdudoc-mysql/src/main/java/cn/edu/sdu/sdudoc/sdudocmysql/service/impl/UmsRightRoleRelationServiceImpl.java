package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRoleRightRelation;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRoleRightRelationExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsRoleRightRelationMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.UmsRoleRightRelationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UmsRightRoleRelationServiceImpl implements UmsRoleRightRelationService {

    @Autowired
    UmsRoleRightRelationMapper umsRoleRightRelationMapper;

    @Override
    public long countByExample(UmsRoleRightRelationExample example) {
        return umsRoleRightRelationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsRoleRightRelationExample example) {
        return umsRoleRightRelationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer rrid) {
        return umsRoleRightRelationMapper.deleteByPrimaryKey(rrid);
    }

    @Override
    public int insert(UmsRoleRightRelation record) {
        return umsRoleRightRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsRoleRightRelation record) {
        return umsRoleRightRelationMapper.insertSelective(record);
    }

    @Override
    public List<UmsRoleRightRelation> selectByExample(UmsRoleRightRelationExample example) {
        return umsRoleRightRelationMapper.selectByExample(example);
    }

    @Override
    public UmsRoleRightRelation selectByPrimaryKey(Integer rrid) {
        return umsRoleRightRelationMapper.selectByPrimaryKey(rrid);
    }

    @Override
    public int updateByExampleSelective(UmsRoleRightRelation record, UmsRoleRightRelationExample example) {
        return umsRoleRightRelationMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UmsRoleRightRelation record, UmsRoleRightRelationExample example) {
        return umsRoleRightRelationMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRoleRightRelation record) {
        return umsRoleRightRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsRoleRightRelation record) {
        return umsRoleRightRelationMapper.updateByPrimaryKey(record);
    }
}
