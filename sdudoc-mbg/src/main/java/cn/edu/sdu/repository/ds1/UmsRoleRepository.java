package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.UmsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1UmsRoleRepository")
public interface UmsRoleRepository extends JpaRepository<UmsRole, Integer> {
}
