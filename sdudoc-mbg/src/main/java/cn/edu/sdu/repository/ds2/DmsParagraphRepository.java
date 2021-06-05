package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.DmsParagraph;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2DmsParagraphRepository")
public interface DmsParagraphRepository extends MongoRepository<DmsParagraph,String> {
}
