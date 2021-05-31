package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.SmsArticleHead;
import org.apache.zookeeper.Op;

import java.util.List;
import java.util.Optional;

public interface SmsArticleHeadService {

    SmsArticleHead save(SmsArticleHead smsArticleHead);

    List<SmsArticleHead> saveAll(List<SmsArticleHead> smsArticleHeads);

    void delete(String id);

    void update(SmsArticleHead smsArticleHead);

    Optional<SmsArticleHead> findOne(SmsArticleHead smsArticleHead);

    Optional<SmsArticleHead> findById(String id);

    List<SmsArticleHead> findAll();

    List<String> findAll_id();

    List<SmsArticleHead> find(String field, String keyword);
}
