package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsSentence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1DmsSentenceRepository")
public interface DmsSentenceRepository extends MongoRepository<DmsSentence,String> {
}
