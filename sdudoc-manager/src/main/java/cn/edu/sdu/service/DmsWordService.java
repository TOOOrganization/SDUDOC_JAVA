package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsWord;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DmsWordService {

    DmsWord save(DmsWord dmsWord);

    List<DmsWord> saveAll(List<DmsWord> dmsWords);

    void delete(String id);

    void update(DmsWord dmsWord);

    Optional<DmsWord> findById(String id);

    List<DmsWord> findAll();

    Set<String> findAllArticle();

    List<DmsWord> find(String field, String keyword);
}
