package cn.edu.sdu.search.service;

import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.entity.ds2.SmsUserBookmarkRelation;
import cn.edu.sdu.common.exception.HttpStatusException;

import java.util.List;

public interface SmsUserBookmarkRelationService {

    SmsUserBookmarkRelation insert(String username, String aid);

    List<SmsArticleHead> find(String username) throws HttpStatusException;

    void delete(String username, String aid);

    Boolean exist(String username, String aid);
}
