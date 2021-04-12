package cn.edu.sdu.sdudoc.sdudocdao.mapper;

import cn.edu.sdu.sdudoc.sdudocdao.entity.SmsArticleHead;
import cn.edu.sdu.sdudoc.sdudocdao.entity.SmsArticleHeadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsArticleHeadMapper {
    long countByExample(SmsArticleHeadExample example);

    int deleteByExample(SmsArticleHeadExample example);

    int deleteByPrimaryKey(String aid);

    int insert(SmsArticleHead record);

    int insertSelective(SmsArticleHead record);

    List<SmsArticleHead> selectByExample(SmsArticleHeadExample example);

    SmsArticleHead selectByPrimaryKey(String aid);

    int updateByExampleSelective(@Param("record") SmsArticleHead record, @Param("example") SmsArticleHeadExample example);

    int updateByExample(@Param("record") SmsArticleHead record, @Param("example") SmsArticleHeadExample example);

    int updateByPrimaryKeySelective(SmsArticleHead record);

    int updateByPrimaryKey(SmsArticleHead record);
}