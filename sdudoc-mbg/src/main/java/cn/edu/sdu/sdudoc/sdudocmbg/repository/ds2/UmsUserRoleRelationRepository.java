package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsUserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2UmsUserRoleRelationRepository")
public interface UmsUserRoleRelationRepository extends JpaRepository<UmsUserRoleRelation, Integer> {
}
