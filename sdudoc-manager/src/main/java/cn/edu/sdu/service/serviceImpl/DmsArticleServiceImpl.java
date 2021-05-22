package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.service.DmsArticleService;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.DmsArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
    public List<DmsArticle> findBybookname(String bookname) {
        return dmsArticleRepository.findBybookname(bookname);
    }

    @Override
    public List<DmsArticle> findByTitle(String title){
        return dmsArticleRepository.findByTitle(title);
    }

    @Override
    public List<DmsArticle> findByArticleAuthor(String articleAuthor){
        return dmsArticleRepository.findByArticleAuthor(articleAuthor);
    }
}
