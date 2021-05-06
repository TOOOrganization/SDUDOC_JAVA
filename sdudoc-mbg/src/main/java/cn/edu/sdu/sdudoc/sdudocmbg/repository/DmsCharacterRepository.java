package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmsCharacterRepository extends MongoRepository<DmsCharacter,String> {

//    DmsCharacter save(DmsCharacter dmsCharacter);
//
//    List<DmsCharacter> saveAll(Iterable dmsCharacters);
}
