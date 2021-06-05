package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.SmsUserBookmarkRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "ds2SmsUserBookmarkRelationRepository")
public interface SmsUserBookmarkRelationRepository extends JpaRepository<SmsUserBookmarkRelation, String> {

    List<SmsUserBookmarkRelation> findByUsername(String username);

    @Transactional
    void deleteByUsernameAndAid(String username, String aid);

    Boolean existsByUsernameAndAid(String username, String aid);
}
