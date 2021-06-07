package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.repository.ds1.DmsWordRepository;
import cn.edu.sdu.service.DmsWordService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DmsWordServiceImpl implements DmsWordService {

    @Autowired
    DmsWordRepository dmsWordRepository;

    @Override
    public DmsWord save(DmsWord dmsWord) {
        return dmsWordRepository.save(dmsWord);
    }

    @Override
    public List<DmsWord> saveAll(List<DmsWord> dmsWords) {
        return dmsWordRepository.saveAll(dmsWords);
    }

    @Override
    public void delete(String id) {
        dmsWordRepository.deleteById(id);
    }

    @Override
    public void deleteMany(String entities) {
        System.out.println(entities);
        List<DmsWord> entitiesList = JSONArray.parseArray(entities, DmsWord.class);
        System.out.println(entitiesList);
        dmsWordRepository.deleteAll(entitiesList);
    }

    @Override
    public void update(DmsWord dmsWord) {
        dmsWordRepository.save(dmsWord);
    }

    @Override
    public Optional<DmsWord> findById(String id) {
        return dmsWordRepository.findById(id);
    }

    @Override
    public List<DmsWord> findAll() {
        return dmsWordRepository.findAll();
    }

    @Override
    public Set<String> findAllArticle() {
        Set<String> articleSet = new HashSet<>();
        List<DmsWord> dmsWordList = dmsWordRepository.findAll();
        for (DmsWord dmsWord : dmsWordList)
            articleSet.add(dmsWord.getArticle());
        return articleSet;
    }

    @Override
    public List<DmsWord> find(String field, String keyword) {
        List<DmsWord> result = new ArrayList<>();
        switch (field){
            case "_id":
                result.add(dmsWordRepository.findById(keyword).get());
                break;
            case "word":
                result = dmsWordRepository.findByWord(keyword);
                break;
            case "article":
                result = dmsWordRepository.findByArticle(keyword);
                break;
            case "page":
                result = dmsWordRepository.findByPage(keyword);
                break;
        }
        return result;
    }

    @Override
    public List<DmsWord> findMany(String field, String keyword) {
        List<String> article_ids = JSONArray.parseArray(keyword, String.class);
        List<DmsWord> result = new ArrayList<>();
        for (int i=0; i< article_ids.size(); i++)
            for (DmsWord dmsWord : find(field, article_ids.get(i)))
                result.add(dmsWord);
        return result;
    }
}
