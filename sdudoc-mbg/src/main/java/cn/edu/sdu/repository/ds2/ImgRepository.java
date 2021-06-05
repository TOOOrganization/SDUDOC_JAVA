package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2ImgRepository")
public interface ImgRepository extends JpaRepository<Img, Long> {
}
