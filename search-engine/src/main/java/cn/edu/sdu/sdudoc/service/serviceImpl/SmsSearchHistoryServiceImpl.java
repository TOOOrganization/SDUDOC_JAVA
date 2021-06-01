package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsSearchHistory;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2.SmsSearchHistoryRepository;
import cn.edu.sdu.sdudoc.service.SmsSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsSearchHistoryServiceImpl implements SmsSearchHistoryService {

    @Autowired
    SmsSearchHistoryRepository smsSearchHistoryRepository;


    @Override
    public SmsSearchHistory insert(String username, String word, Integer type) {
        SmsSearchHistory smsSearchHistory = new SmsSearchHistory();
        smsSearchHistory.setUsername(username);
        smsSearchHistory.setWord(word);
        smsSearchHistory.setAddTime(System.currentTimeMillis() / 1000 + "");
        smsSearchHistory.setType(type);
        return smsSearchHistoryRepository.save(smsSearchHistory);
    }

    @Override
    public List<Map<String, String>> find(String username) {
        List<Map<String, String>> result = new ArrayList<>();
//        SmsSearchHistory smsSearchHistory1 = new SmsSearchHistory();
//        smsSearchHistory1.setUsername(username);
//        List<SmsSearchHistory> findResult = smsSearchHistoryRepository.findAll(Example.of(smsSearchHistory1));
//        Sort timeSort = Sort.by(Sort.Direction.DESC, "addTime");
        List<SmsSearchHistory> findResult = smsSearchHistoryRepository.findTop20ByUsernameOrderByAddTimeDesc(username);
        for (SmsSearchHistory smsSearchHistory : findResult){
            Map<String, String> map = new HashMap<>();
            map.put("username", smsSearchHistory.getUsername());
            map.put("add_time", smsSearchHistory.getAddTime());
            map.put("type", smsSearchHistory.getType()+"");
            if (smsSearchHistory.getType() > 6)
                map.put("word", smsSearchHistory.getWord().substring(smsSearchHistory.getWord().indexOf(",") + 1));
            else
                map.put("word", smsSearchHistory.getWord());
            result.add(map);
        }
        return result;
    }
}
