package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.PmsUserPointRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2PmsUserScoreRelationRepository")
public interface PmsUserScoreRelationRepository extends JpaRepository<PmsUserPointRelation, Integer> {
}
