package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.UmsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2UmsRoleRepository")
public interface UmsRoleRepository extends JpaRepository<UmsRole, Integer> {
}
