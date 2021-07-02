package cn.edu.sdu.search;

import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.search.SearchEngineApplication;
import cn.edu.sdu.search.controller.SmsUserBookmarkRelationController;
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
    public void find() throws HttpStatusException {
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
