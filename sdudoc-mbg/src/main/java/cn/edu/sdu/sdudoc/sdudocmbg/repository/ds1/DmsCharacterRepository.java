package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmsCharacterRepository extends MongoRepository<DmsCharacter,String> {

//    DmsCharacter save(DmsCharacter dmsCharacter);
//
//    List<DmsCharacter> saveAll(Iterable dmsCharacters);
}
