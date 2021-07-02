package cn.edu.sdu.editor.util;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.repository.ds1.DmsArticleRepository;
import cn.edu.sdu.repository.ds1.DmsCharacterRepository;
import cn.edu.sdu.repository.ds1.DmsWordRepository;
import cn.edu.sdu.repository.ds1.SmsArticleHeadRepository;
import cn.edu.sdu.common.util.OkHttpUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MongoInput {

    @Autowired
    private DmsArticleRepository dmsArticleRepository;

    @Autowired
    private SmsArticleHeadRepository smsArticleHeadRepository;

    @Autowired
    private DmsCharacterRepository dmsCharacterRepository;

    @Autowired
    private DmsWordRepository dmsWordRepository;


    public DmsArticle saveArticle(DmsArticle dmsArticle){ return dmsArticleRepository.save(dmsArticle);}

    public String saveArticleHead(SmsArticleHead smsArticleHead) throws HttpStatusException {
        String url = "http://211.87.232.199:8080/mysql/article_head/save";
        Map<String, String> map = new HashMap<>();
        map.put("smsArticleHead", JSON.toJSONString(smsArticleHead));
        String result = OkHttpUtil.doPost(url, map, "POST");

        return result;
    }

    public DmsCharacter saveCharacter(DmsCharacter dmsCharacter){ return dmsCharacterRepository.save(dmsCharacter);}

    public DmsWord saveWord(DmsWord dmsWord){ return dmsWordRepository.save(dmsWord);}

    public Optional<DmsArticle> findOneArticle(DmsArticle dmsArticle){ return dmsArticleRepository.findOne(Example.of(dmsArticle)); }
}
