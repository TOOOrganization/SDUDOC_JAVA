package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRight;
import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsRightExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.UmsRightMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.UmsRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsRightServiceImpl implements UmsRightService {

    @Autowired
    UmsRightMapper umsRightMapper;

    @Override
    public long countByExample(UmsRightExample example) {
        return umsRightMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UmsRightExample example) {
        return umsRightMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer rightId) {
        return umsRightMapper.deleteByPrimaryKey(rightId);
    }

    @Override
    public int insert(UmsRight record) {
        return umsRightMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsRight record) {
        return umsRightMapper.insertSelective(record);
    }

    @Override
    public List<UmsRight> selectByExample(UmsRightExample example) {
        return umsRightMapper.selectByExample(example);
    }

    @Override
    public UmsRight selectByPrimaryKey(Integer rightId) {
        return umsRightMapper.selectByPrimaryKey(rightId);
    }

    @Override
    public int updateByExampleSelective(UmsRight record, UmsRightExample example) {
        return umsRightMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UmsRight record, UmsRightExample example) {
        return umsRightMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsRight record) {
        return umsRightMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsRight record) {
        return umsRightMapper.updateByPrimaryKey(record);
    }
}
