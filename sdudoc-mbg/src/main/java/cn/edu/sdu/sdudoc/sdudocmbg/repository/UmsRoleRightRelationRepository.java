package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsRoleRightRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsRoleRightRelationRepository extends JpaRepository<UmsRoleRightRelation, Integer> {
}
