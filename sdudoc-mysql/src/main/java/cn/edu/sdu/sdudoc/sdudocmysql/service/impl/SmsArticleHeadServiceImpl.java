package cn.edu.sdu.sdudoc.sdudocmysql.service.impl;

import cn.edu.sdu.sdudoc.sdudocdao.entity.SmsArticleHead;
import cn.edu.sdu.sdudoc.sdudocdao.entity.SmsArticleHeadExample;
import cn.edu.sdu.sdudoc.sdudocdao.mapper.SmsArticleHeadMapper;
import cn.edu.sdu.sdudoc.sdudocmysql.service.SmsArticleHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsArticleHeadServiceImpl implements SmsArticleHeadService {

    @Autowired
    SmsArticleHeadMapper smsArticleHeadMapper;

    @Override
    public long countByExample(SmsArticleHeadExample example) {
        return smsArticleHeadMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SmsArticleHeadExample example) {
        return smsArticleHeadMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String aid) {
        return smsArticleHeadMapper.deleteByPrimaryKey(aid);
    }

    @Override
    public int insert(SmsArticleHead record) {
        return smsArticleHeadMapper.insert(record);
    }

    @Override
    public int insertSelective(SmsArticleHead record) {
        return smsArticleHeadMapper.insertSelective(record);
    }

    @Override
    public List<SmsArticleHead> selectByExample(SmsArticleHeadExample example) {
        return smsArticleHeadMapper.selectByExample(example);
    }

    @Override
    public SmsArticleHead selectByPrimaryKey(String aid) {
        return smsArticleHeadMapper.selectByPrimaryKey(aid);
    }

    @Override
    public int updateByExampleSelective(SmsArticleHead record, SmsArticleHeadExample example) {
        return smsArticleHeadMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SmsArticleHead record, SmsArticleHeadExample example) {
        return smsArticleHeadMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsArticleHead record) {
        return smsArticleHeadMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmsArticleHead record) {
        return smsArticleHeadMapper.updateByPrimaryKey(record);
    }
}
