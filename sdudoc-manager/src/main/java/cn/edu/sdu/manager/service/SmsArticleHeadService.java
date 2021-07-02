package cn.edu.sdu.manager.service;

import cn.edu.sdu.entity.ds1.SmsArticleHead;

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
