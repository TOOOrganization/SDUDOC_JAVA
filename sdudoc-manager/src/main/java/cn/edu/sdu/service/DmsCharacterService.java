package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DmsCharacterService {
    DmsCharacter save(DmsCharacter dmsCharacter);

    List<DmsCharacter> saveAll(List<DmsCharacter> dmsCharacter);

    void delete(String id);

    void update(DmsCharacter dmsCharacter);

    Optional<DmsCharacter> findById(String id);

    List<DmsCharacter> findAll();

    Set<String> findAllArticle();

    List<DmsCharacter> find(String field, String keyword);
}
