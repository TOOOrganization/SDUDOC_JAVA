package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.DmsCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds1DmsCharacterRepository")
public interface DmsCharacterRepository extends MongoRepository<DmsCharacter,String> {

    List<DmsCharacter> findByCharacter(String character);

    List<DmsCharacter> findByArticle(String title);

    List<DmsCharacter> findByPage(String page);

}
