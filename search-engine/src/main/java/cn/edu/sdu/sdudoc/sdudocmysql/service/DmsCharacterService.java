package cn.edu.sdu.sdudoc.sdudocmysql.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;

import java.util.List;

public interface DmsCharacterService {
    void save(DmsCharacter dmsCharacter);

    List<DmsCharacter> saveAll(List dmsCharacter);

    void delete(String id);

    void update(DmsCharacter dmsCharacter);

    List<DmsCharacter> findAll();
}
