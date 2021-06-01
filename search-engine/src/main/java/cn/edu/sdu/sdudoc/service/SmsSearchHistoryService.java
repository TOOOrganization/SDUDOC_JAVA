package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsSearchHistory;

import java.util.List;
import java.util.Map;

public interface SmsSearchHistoryService {

    SmsSearchHistory insert(String username, String word, Integer type);

    List<Map<String, String>> find(String username);
}
