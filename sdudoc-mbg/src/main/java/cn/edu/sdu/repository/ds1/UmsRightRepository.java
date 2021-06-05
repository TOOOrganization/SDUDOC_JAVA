package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.UmsRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1UmsRightRepository")
public interface UmsRightRepository extends JpaRepository<UmsRight, Integer> {
}
