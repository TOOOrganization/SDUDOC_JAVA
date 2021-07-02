package cn.edu.sdu.manager.service;

import cn.edu.sdu.entity.ds1.DmsWord;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DmsWordService {

    DmsWord save(DmsWord dmsWord);

    List<DmsWord> saveAll(List<DmsWord> dmsWords);

    void delete(String id);

    void deleteMany(String entities);

    void update(DmsWord dmsWord);

    Optional<DmsWord> findById(String id);

    List<DmsWord> findAll();

    Set<String> findAllArticle();

    List<DmsWord> find(String field, String keyword);

    List<DmsWord> findMany(String field, String keyword);
}
