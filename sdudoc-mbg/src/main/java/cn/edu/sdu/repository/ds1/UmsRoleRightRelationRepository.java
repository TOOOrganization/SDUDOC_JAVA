package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.UmsRoleRightRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1UmsRoleRightRelationRepository")
public interface UmsRoleRightRelationRepository extends JpaRepository<UmsRoleRightRelation, Integer> {
}
