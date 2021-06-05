package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.UmsRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2UmsRightRepository")
public interface UmsRightRepository extends JpaRepository<UmsRight, Integer> {
}
