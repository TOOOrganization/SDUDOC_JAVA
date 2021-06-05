package cn.edu.sdu;

import cn.edu.sdu.controller.SmsUserBookmarkRelationController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class MarkTest {

    @Autowired
    SmsUserBookmarkRelationController smsUserBookmarkRelationController;

    @Test
    public void insert(){
        smsUserBookmarkRelationController.insert("123","111");

    }

    @Test
    public void find(){
        System.out.println(smsUserBookmarkRelationController.find("123"));
    }

    @Test
    public void delete(){
        smsUserBookmarkRelationController.delete("123","111");
    }

    @Test
    public void exist(){
        System.out.println(smsUserBookmarkRelationController.exist("12345", "111"));
    }
}
