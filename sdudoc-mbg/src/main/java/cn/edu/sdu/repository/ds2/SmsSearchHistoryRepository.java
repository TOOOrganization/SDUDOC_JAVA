package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.SmsSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds2SmsSearchHistoryRepository")
public interface SmsSearchHistoryRepository extends JpaRepository<SmsSearchHistory, Integer> {

    List<SmsSearchHistory> findByUsername(String username);

    List<SmsSearchHistory> findTop20ByUsernameOrderByAddTimeDesc(String username);

    List<SmsSearchHistory> findTop20ByUsernameAndTypeLessThanOrderByAddTimeDesc(String username, Integer type);

    List<SmsSearchHistory> findTop20ByUsernameAndTypeOrderByAddTimeDesc(String username, Integer type);
}
