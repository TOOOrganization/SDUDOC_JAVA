package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.SmsArticleHead;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsUserBookmarkRelation;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.SmsArticleHeadRepository;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2.SmsUserBookmarkRelationRepository;
import cn.edu.sdu.sdudoc.service.SmsUserBookmarkRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsUserBookmarkRelationServiceImpl implements SmsUserBookmarkRelationService {

    @Autowired
    SmsUserBookmarkRelationRepository smsUserBookmarkRelationRepository;

    @Autowired
    SmsArticleHeadRepository smsArticleHeadRepository;

    @Override
    public SmsUserBookmarkRelation insert(String username, String aid) {
        SmsUserBookmarkRelation smsUserBookmarkRelation = new SmsUserBookmarkRelation(username, aid);
        smsUserBookmarkRelation.setAdd_time(System.currentTimeMillis() / 1000 +"");
        System.out.println(smsUserBookmarkRelation);
        return smsUserBookmarkRelationRepository.save(smsUserBookmarkRelation);
    }

    @Override
    public List<Map<String, String>> find(String username) {
        List<Map<String, String>> result = new ArrayList<>();
        List<SmsUserBookmarkRelation> findResult = smsUserBookmarkRelationRepository.findAll();
        for (SmsUserBookmarkRelation smsUserBookmarkRelation : findResult){
            Map<String, String> map = new HashMap<>();
            SmsArticleHead smsArticleHead = smsArticleHeadRepository.findById(smsUserBookmarkRelation.getAid()).get();
            map.put("title", smsArticleHead.getTitle());
            map.put("articleAuthor", smsArticleHead.getArticleauthor());
            map.put("bookname", smsArticleHead.getBookname());
            map.put("dynasty", smsArticleHead.getDynasty());
            result.add(map);
        }
        return result;
    }
}
