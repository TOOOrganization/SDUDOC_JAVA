package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.PmsUserScoreRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1PmsUserScoreRelationRepository")
public interface PmsUserScoreRelationRepository extends JpaRepository<PmsUserScoreRelation, Integer> {
}
