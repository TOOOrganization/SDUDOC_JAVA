package cn.edu.sdu.search.service;

import cn.edu.sdu.entity.ds2.SmsSearchHistory;

import java.util.List;
import java.util.Map;

public interface SmsSearchHistoryService {

    SmsSearchHistory insert(String username, String word, Integer type);

    List<Map<String, String>> find(String username, Integer type);
}
