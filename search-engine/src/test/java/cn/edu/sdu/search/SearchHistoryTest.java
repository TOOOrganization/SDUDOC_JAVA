package cn.edu.sdu.search;

import cn.edu.sdu.search.controller.SmsSearchHistoryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchHistoryTest {

    @Autowired
    SmsSearchHistoryController smsSearchHistoryController;

    @Test
    public void insert(){
        smsSearchHistoryController.insert("link", "126351561616,为您展示", 7);
    }

    @Test
    public void find(){
        System.out.println(smsSearchHistoryController.find("link", 3));
    }
}
