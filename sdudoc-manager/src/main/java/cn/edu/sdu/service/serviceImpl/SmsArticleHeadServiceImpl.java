package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.entity.ds1.SmsArticleHead;
import cn.edu.sdu.repository.ds1.SmsArticleHeadRepository;
import cn.edu.sdu.service.SmsArticleHeadService;
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
}
