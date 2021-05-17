package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.DmsCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2DmsCharacterRepository")
public interface DmsCharacterRepository extends MongoRepository<DmsCharacter,String> {

//    DmsCharacter save(DmsCharacter dmsCharacter);
//
//    List<DmsCharacter> saveAll(Iterable dmsCharacters);
}
