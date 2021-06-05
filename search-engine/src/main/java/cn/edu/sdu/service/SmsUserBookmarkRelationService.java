package cn.edu.sdu.service;

import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.entity.ds2.SmsUserBookmarkRelation;

import java.util.List;
import java.util.Map;

public interface SmsUserBookmarkRelationService {

    SmsUserBookmarkRelation insert(String username, String aid);

    List<SmsArticleHead> find(String username);

    void delete(String username, String aid);

    Boolean exist(String username, String aid);
}
