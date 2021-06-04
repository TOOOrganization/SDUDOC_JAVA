package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.controller.SmsUserBookmarkRelationController;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.SmsUserBookmarkRelation;
import cn.edu.sdu.sdudoc.service.SmsUserBookmarkRelationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
}
