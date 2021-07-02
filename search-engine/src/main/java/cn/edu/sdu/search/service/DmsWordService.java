package cn.edu.sdu.search.service;

import cn.edu.sdu.entity.ds1.DmsWord;

import java.util.List;

public interface DmsWordService {
    DmsWord save(DmsWord dmsWord);

    List<DmsWord> saveAll(List<DmsWord> dmsWords);

    void delete(String id);

    void update(DmsWord dmsWord);

    List<DmsWord> findAll();
}
