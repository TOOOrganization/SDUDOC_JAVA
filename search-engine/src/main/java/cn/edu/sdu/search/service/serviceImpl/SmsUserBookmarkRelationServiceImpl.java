package cn.edu.sdu.search.service.serviceImpl;

import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.entity.ds2.SmsUserBookmarkRelation;
import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.repository.ds1.SmsArticleHeadRepository;
import cn.edu.sdu.repository.ds2.SmsUserBookmarkRelationRepository;
import cn.edu.sdu.search.service.SmsUserBookmarkRelationService;
import cn.edu.sdu.common.util.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<SmsArticleHead> find(String username) throws HttpStatusException {
        List<SmsUserBookmarkRelation> findResult = smsUserBookmarkRelationRepository.findByUsername(username);
        List<String> ids = new ArrayList<>();
        for (SmsUserBookmarkRelation smsUserBookmarkRelation : findResult){
            ids.add(smsUserBookmarkRelation.getAid());
        }
        String url = "http://211.87.232.199:8080/mysql/article_head/findAllById";
        Map<String, String> map = new HashMap<>();
        map.put("ids", JSON.toJSONString(ids));
        String httpResult = OkHttpUtil.doPost(url, map, "POST");
        //        SmsArticleHead smsArticleHead = smsArticleHeadRepository.findById(smsUserBookmarkRelation.getAid()).get();
//        result.add(smsArticleHead);
        return JSONArray.parseArray(httpResult, SmsArticleHead.class);
    }

    @Override
    public void delete(String username, String aid) {
        smsUserBookmarkRelationRepository.deleteByUsernameAndAid(username, aid);
    }

    @Override
    public Boolean exist(String username, String aid) {
        return smsUserBookmarkRelationRepository.existsByUsernameAndAid(username, aid);
    }
}
