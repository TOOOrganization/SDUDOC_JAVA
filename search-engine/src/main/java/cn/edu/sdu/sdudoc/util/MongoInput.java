package cn.edu.sdu.sdudoc.util;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsWord;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.SmsArticleHead;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.SmsArticleHeadRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.DmsCharacterService;
import cn.edu.sdu.sdudoc.service.DmsWordService;
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
