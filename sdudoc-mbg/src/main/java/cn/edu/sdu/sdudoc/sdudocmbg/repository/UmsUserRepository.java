package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UmsUserRepository extends JpaRepository<UmsUser,Integer> {
    //List<UmsUser> findAll();

    //List<UmsUser> findByUid(String uid);

    //UmsUser save(UmsUser msEntity);

    List<UmsUser> findByUsername(String username);

    List<UmsUser> findByEmail(String email);

    List<UmsUser> findByPhone(String phone);

    List<UmsUser> findByLoginTime(Date loginTime);

}