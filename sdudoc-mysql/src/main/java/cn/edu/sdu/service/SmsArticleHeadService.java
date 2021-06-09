package cn.edu.sdu.service;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.SmsArticleHead;

import java.util.List;
import java.util.Optional;

public interface SmsArticleHeadService {

    SmsArticleHead save(SmsArticleHead smsArticleHead);

    List<SmsArticleHead> saveAll(List<SmsArticleHead> smsArticleHeads);

    void delete(String id);

    void deleteMany(String entities);

    void update(SmsArticleHead smsArticleHead);

    Optional<SmsArticleHead> findOne(SmsArticleHead smsArticleHead);

    Optional<SmsArticleHead> findById(String id);

    List<SmsArticleHead> findAll();

    List<SmsArticleHead> findAllById(String ids);

    List<String> findAll_id();

    List<SmsArticleHead> find(String field, String keyword);

    List<SmsArticleHead> findMany(String field, String keyword);
}
