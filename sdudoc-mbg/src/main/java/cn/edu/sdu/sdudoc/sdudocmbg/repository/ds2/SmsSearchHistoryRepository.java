package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds2;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.SmsSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds2SmsSearchHistoryRepository")
public interface SmsSearchHistoryRepository extends JpaRepository<SmsSearchHistory, Integer> {

    List<SmsSearchHistory> findByUsername(String username);

    List<SmsSearchHistory> findTop20ByUsernameOrderByAddTimeDesc(String username);
}
