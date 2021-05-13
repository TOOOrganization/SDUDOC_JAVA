package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsWord;

import java.util.List;

public interface DmsWordService {
    DmsWord save(DmsWord dmsWord);

    List<DmsWord> saveAll(List dmsWords);

    void delete(String id);

    void update(DmsWord dmsWord);

    List<DmsWord> findAll();
}
