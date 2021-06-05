package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.service.DmsArticleService;
import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.repository.ds1.DmsArticleRepository;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DmsArticleServiceImpl implements DmsArticleService {

    @Autowired
    private DmsArticleRepository dmsArticleRepository;

    @Override
    public DmsArticle save(DmsArticle dmsArticle) {
        return dmsArticleRepository.save(dmsArticle);
    }

    @Override
    public List<DmsArticle> saveAll(List<DmsArticle> articles){
        return dmsArticleRepository.saveAll(articles);
    }

    @Override
    public void delete(String id) {
        dmsArticleRepository.deleteById(id);
    }

    @Override
    public void deleteMany(String entities) {
        System.out.println(entities);
        List<DmsArticle> entitiesList = JSONArray.parseArray(entities, DmsArticle.class);
        System.out.println(entitiesList);
        dmsArticleRepository.deleteAll(entitiesList);
    }

    @Override
    public void update(DmsArticle dmsArticle){
        dmsArticleRepository.save(dmsArticle);
    }

    @Override
    public Optional<DmsArticle> findOne(DmsArticle dmsArticle){ return dmsArticleRepository.findOne(Example.of(dmsArticle));}

    @Override
    public Optional<DmsArticle> findById(String id){ return dmsArticleRepository.findById(id);}

    @Override
    public List<DmsArticle> findAll() {
        return dmsArticleRepository.findAll();
    }

    @Override
    public List<String> findAll_id() {
        List<String> _idList = new ArrayList<>();
        List<DmsArticle> dmsArticleList = dmsArticleRepository.findAll();
        for (DmsArticle dmsArticle : dmsArticleList)
            _idList.add(dmsArticle.get_id());
        return _idList;
    }

    @Override
    public List<DmsArticle> find(String field, String keyword){
        List<DmsArticle> result = new ArrayList<>();
        switch(field){
            case "_id" :
                result.add(dmsArticleRepository.findById(keyword).get());
                break;
            case "title" :
                result = dmsArticleRepository.findByTitle(keyword);
                break;
            case "articleAuthor" :
                result = dmsArticleRepository.findByArticleAuthor(keyword);
                break;
            case "bookname" :
                result = dmsArticleRepository.findByBookname(keyword);
                break;
            case "dynasty" :
                result = dmsArticleRepository.findByDynasty(keyword);
                break;
            case "content" :
                result = dmsArticleRepository.findByContent(keyword);
                break;
        }
        return result;
    }

    @Override
    public List<DmsArticle> findMany(String field, String keyword) {
        List<String> _ids = JSONArray.parseArray(keyword, String.class);
        List<DmsArticle> result = new ArrayList<>();
        for (int i=0; i< _ids.size(); i++)
            for (DmsArticle dmsArticle : find(field, _ids.get(i)))
                result.add(dmsArticle);
        return result;
    }

//    @Override
//    public List<DmsArticle> findByBookname(String bookname) {
//        return dmsArticleRepository.findBybookname(bookname);
//    }
//
//    @Override
//    public List<DmsArticle> findByTitle(String title){
//        return dmsArticleRepository.findByTitle(title);
//    }
//
//    @Override
//    public List<DmsArticle> findByArticleAuthor(String articleAuthor){
//        return dmsArticleRepository.findByArticleAuthor(articleAuthor);
//    }
//
//    @Override
//    public List<DmsArticle> findByDynasty(String dynasty){
//        return dmsArticleRepository.findByDynasty(dynasty);
//    }
//
//    @Override
//    public List<DmsArticle> findByContent(String content){
//        return dmsArticleRepository.findByContent(content);
//    }
}
