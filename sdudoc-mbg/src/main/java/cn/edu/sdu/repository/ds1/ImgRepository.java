package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1ImgRepository")
public interface ImgRepository extends JpaRepository<Img, Long> {
}
