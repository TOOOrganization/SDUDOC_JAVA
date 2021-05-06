package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UmsUserService extends JpaRepository<UmsUser, Integer> {
}
