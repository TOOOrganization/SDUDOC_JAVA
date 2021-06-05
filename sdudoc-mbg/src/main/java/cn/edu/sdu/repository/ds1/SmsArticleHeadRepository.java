package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.SmsArticleHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds1SmsArticleHeadRepository")
public interface SmsArticleHeadRepository extends JpaRepository<SmsArticleHead, String> {

    List<SmsArticleHead> findByTitle(String title);

    List<SmsArticleHead> findByArticleauthor(String articleAuthor);

    List<SmsArticleHead> findByBookname(String bookname);

    List<SmsArticleHead> findByDynasty(String dynasty);
}
