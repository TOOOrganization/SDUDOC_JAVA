package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsUserBookmarkRelation;

import java.util.List;
import java.util.Map;

public interface SmsUserBookmarkRelationService {

    SmsUserBookmarkRelation insert(String username, String aid);

    List<Map<String, String>> find(String username);
}
