package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.PmsUserPointRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2PmsUserScoreRelationRepository")
public interface PmsUserScoreRelationRepository extends JpaRepository<PmsUserPointRelation, Integer> {
}
