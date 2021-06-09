package cn.edu.sdu.service.impl;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.repository.ds1.SmsArticleHeadRepository;
import cn.edu.sdu.service.SmsArticleHeadService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SmsArticleHeadServiceImpl implements SmsArticleHeadService {

    @Autowired
    SmsArticleHeadRepository smsArticleHeadRepository;


    @Override
    public SmsArticleHead save(SmsArticleHead smsArticleHead) {
        return smsArticleHeadRepository.save(smsArticleHead);
    }

    @Override
    public List<SmsArticleHead> saveAll(List<SmsArticleHead> smsArticleHeads) {
        return smsArticleHeadRepository.saveAll(smsArticleHeads);
    }

    @Override
    public void delete(String id) {
        smsArticleHeadRepository.deleteById(id);
    }

    @Override
    public void deleteMany(String entities) {
        System.out.println(entities);
        List<SmsArticleHead> entitiesList = JSONArray.parseArray(entities, SmsArticleHead.class);
        System.out.println(entitiesList);
        smsArticleHeadRepository.deleteAll(entitiesList);
    }

    @Override
    public void update(SmsArticleHead smsArticleHead) {
        smsArticleHeadRepository.save(smsArticleHead);
    }

    @Override
    public Optional<SmsArticleHead> findOne(SmsArticleHead smsArticleHead) {
        return smsArticleHeadRepository.findOne(Example.of(smsArticleHead));
    }

    @Override
    public Optional<SmsArticleHead> findById(String id) {
        return smsArticleHeadRepository.findById(id);
    }

    @Override
    public List<SmsArticleHead> findAll() {
        return smsArticleHeadRepository.findAll();
    }

    @Override
    public List<SmsArticleHead> findAllById(String ids) {
        List<String> idList = JSONArray.parseArray(ids, String.class);
        return smsArticleHeadRepository.findAllById(idList);
    }

    @Override
    public List<String> findAll_id() {
        List<String> _idList = new ArrayList<>();
        List<SmsArticleHead> smsArticleHeadList = smsArticleHeadRepository.findAll();
        for (SmsArticleHead smsArticleHead : smsArticleHeadList)
            _idList.add(smsArticleHead.getAid());
        return _idList;
    }

    @Override
    public List<SmsArticleHead> find(String field, String keyword) {
        List<SmsArticleHead> result = new ArrayList<>();
        switch (field) {
            case "aid":
                result.add(smsArticleHeadRepository.findById(keyword).get());
                break;
            case "title":
                result = smsArticleHeadRepository.findByTitle(keyword);
                break;
            case "articleAuthor":
                result = smsArticleHeadRepository.findByArticleauthor(keyword);
                break;
            case "bookname":
                result = smsArticleHeadRepository.findByBookname(keyword);
                break;
            case "dynasty":
                result = smsArticleHeadRepository.findByDynasty(keyword);
                break;
        }
        return result;
    }

    @Override
    public List<SmsArticleHead> findMany(String field, String keyword) {
        List<String> _ids = JSONArray.parseArray(keyword, String.class);
        List<SmsArticleHead> result = new ArrayList<>();
        for (int i=0; i< _ids.size(); i++)
            for (SmsArticleHead smsArticleHead : find(field, _ids.get(i)))
                result.add(smsArticleHead);
        return result;
    }
}
