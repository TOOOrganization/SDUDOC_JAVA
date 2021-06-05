package cn.edu.sdu.util;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.repository.ds1.DmsArticleRepository;
import cn.edu.sdu.repository.ds1.DmsCharacterRepository;
import cn.edu.sdu.repository.ds1.DmsWordRepository;
import cn.edu.sdu.repository.ds1.SmsArticleHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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

    public SmsArticleHead saveArticleHead(SmsArticleHead smsArticleHead){ return smsArticleHeadRepository.save(smsArticleHead);}

    public DmsCharacter saveCharacter(DmsCharacter dmsCharacter){ return dmsCharacterRepository.save(dmsCharacter);}

    public DmsWord saveWord(DmsWord dmsWord){ return dmsWordRepository.save(dmsWord);}

    public Optional<DmsArticle> findOneArticle(DmsArticle dmsArticle){ return dmsArticleRepository.findOne(Example.of(dmsArticle)); }
}
