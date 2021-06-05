package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.UmsUserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1UmsUserRoleRelationRepository")
public interface UmsUserRoleRelationRepository extends JpaRepository<UmsUserRoleRelation, Integer> {
}
