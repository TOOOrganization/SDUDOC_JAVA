package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.UmsUserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "ds2UmsUserRoleRelationRepository")
public interface UmsUserRoleRelationRepository extends JpaRepository<UmsUserRoleRelation, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update ums_user_role_relation set rid = ?2 where uid = ?1", nativeQuery = true)
    int update(Integer userId, Integer roleId);
}

