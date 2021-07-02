package cn.edu.sdu.search.util;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.search.service.DmsArticleService;
import cn.edu.sdu.search.service.DmsCharacterService;
import cn.edu.sdu.search.service.DmsWordService;
import cn.edu.sdu.repository.ds1.SmsArticleHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MongoInput {

    @Autowired
    private DmsArticleService dmsArticleService;

    @Autowired
    private SmsArticleHeadRepository smsArticleHeadRepository;

    @Autowired
    private DmsCharacterService dmsCharacterService;

    @Autowired
    private DmsWordService dmsWordService;

    public DmsArticle saveArticle(DmsArticle dmsArticle){ return dmsArticleService.save(dmsArticle);}

    public SmsArticleHead saveArticleHead(SmsArticleHead smsArticleHead){ return smsArticleHeadRepository.save(smsArticleHead);}

    public DmsCharacter saveCharacter(DmsCharacter dmsCharacter){ return dmsCharacterService.save(dmsCharacter);}

    public DmsWord saveWord(DmsWord dmsWord){ return dmsWordService.save(dmsWord);}

    public Optional<DmsArticle> findOneArticle(DmsArticle dmsArticle){return dmsArticleService.findOne(dmsArticle);}
}
