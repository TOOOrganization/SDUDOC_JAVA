package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;

import java.util.List;
import java.util.Optional;

public interface DmsCharacterService {
    DmsCharacter save(DmsCharacter dmsCharacter);

    List<DmsCharacter> saveAll(List dmsCharacter);

    void delete(String id);

    void update(DmsCharacter dmsCharacter);

    Optional<DmsCharacter> findById(String id);

    List<DmsCharacter> findAll();
}
