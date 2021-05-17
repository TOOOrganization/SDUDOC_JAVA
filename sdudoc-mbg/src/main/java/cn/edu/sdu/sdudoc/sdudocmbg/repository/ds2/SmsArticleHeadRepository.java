package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsArticleHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2SmsArticleHeadRepository")
public interface SmsArticleHeadRepository extends JpaRepository<SmsArticleHead, String> {
}
