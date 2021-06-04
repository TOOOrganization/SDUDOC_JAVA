package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.SmsUserBookmarkRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1SmsUserBookmarkRelationRepository")
public interface SmsUserBookmarkRelationRepository extends JpaRepository<SmsUserBookmarkRelation, String> {
}
