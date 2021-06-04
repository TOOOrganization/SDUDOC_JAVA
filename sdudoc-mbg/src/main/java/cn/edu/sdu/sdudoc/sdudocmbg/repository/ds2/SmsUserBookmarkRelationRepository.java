package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsUserBookmarkRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2SmsUserBookmarkRelationRepository")
public interface SmsUserBookmarkRelationRepository extends JpaRepository<SmsUserBookmarkRelation, String> {
}
