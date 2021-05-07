package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.PmsUserScoreRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PmsUserScoreRelationService extends JpaRepository<PmsUserScoreRelation, Integer> {
}
