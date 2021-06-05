package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.DmsWord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2DmsWordRepository")
public interface DmsWordRepository extends MongoRepository<DmsWord,String> {
}
