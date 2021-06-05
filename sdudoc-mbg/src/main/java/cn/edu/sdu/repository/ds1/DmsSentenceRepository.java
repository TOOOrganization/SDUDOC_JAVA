package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.DmsSentence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1DmsSentenceRepository")
public interface DmsSentenceRepository extends MongoRepository<DmsSentence,String> {
}
