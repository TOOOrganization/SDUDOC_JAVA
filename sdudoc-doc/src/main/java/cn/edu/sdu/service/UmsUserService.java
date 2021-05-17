package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UmsUserService extends JpaRepository<UmsUser, String> {
}
