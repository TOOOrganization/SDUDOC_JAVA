package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsParagraph;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1DmsParagraphRepository")
public interface DmsParagraphRepository extends MongoRepository<DmsParagraph,String> {
}
