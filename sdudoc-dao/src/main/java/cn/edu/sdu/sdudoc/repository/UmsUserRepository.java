package cn.edu.sdu.sdudoc.repository;

import cn.edu.sdu.sdudoc.entity.UmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UmsUserRepository extends JpaRepository<UmsUser,String> {
//    List<UmsUser> findAll();
//
//    List<UmsUser> findByUid(String uid);
}
