package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.DmsSentence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2DmsSentenceRepository")
public interface DmsSentenceRepository extends MongoRepository<DmsSentence,String> {

}
