package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.UmsRoleRightRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2UmsRoleRightRelationRepository")
public interface UmsRoleRightRelationRepository extends JpaRepository<UmsRoleRightRelation, Integer> {
}
