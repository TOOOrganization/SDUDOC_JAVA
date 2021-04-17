package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.entity.SmsArticleHead;
import cn.edu.sdu.sdudoc.entity.SmsArticleHeadExample;
import cn.edu.sdu.sdudoc.mapper.SmsArticleHeadMapper;

import java.util.List;

public interface SmsArticleHeadService extends SmsArticleHeadMapper {
    @Override
    long countByExample(SmsArticleHeadExample example);

    @Override
    int deleteByExample(SmsArticleHeadExample example);

    @Override
    int deleteByPrimaryKey(String aid);

    @Override
    int insert(SmsArticleHead record);

    @Override
    int insertSelective(SmsArticleHead record);

    @Override
    List<SmsArticleHead> selectByExample(SmsArticleHeadExample example);

    @Override
    SmsArticleHead selectByPrimaryKey(String aid);

    @Override
    int updateByExampleSelective(SmsArticleHead record, SmsArticleHeadExample example);

    @Override
    int updateByExample(SmsArticleHead record, SmsArticleHeadExample example);

    @Override
    int updateByPrimaryKeySelective(SmsArticleHead record);

    @Override
    int updateByPrimaryKey(SmsArticleHead record);
}
