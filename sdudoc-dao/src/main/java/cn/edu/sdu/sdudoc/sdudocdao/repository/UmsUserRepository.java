package cn.edu.sdu.sdudoc.sdudocdao.repository;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsUserRepository extends JpaRepository<UmsUser,String> {
//    List<UmsUser> findAll();
//
//    List<UmsUser> findByUid(String uid);
}
