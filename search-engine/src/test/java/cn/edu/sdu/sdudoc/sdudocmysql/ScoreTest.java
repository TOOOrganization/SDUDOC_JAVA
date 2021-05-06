package cn.edu.sdu.sdudoc.sdudocmysql;

import cn.edu.sdu.sdudoc.sdudocmysql.controller.PmsUserScoreRelationController;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.PmsUserScoreRelation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class ScoreTest {

    @Autowired
    PmsUserScoreRelationController pmsUserScoreRelationController;

    @Test
    public void score(){
        PmsUserScoreRelation p = (PmsUserScoreRelation)pmsUserScoreRelationController.find(111);
        System.out.println(p.getUid());
        System.out.println(p.getScore());
        p.setUid(3);
        BigInteger a = new BigInteger(String.valueOf(111));
        pmsUserScoreRelationController.update(123,a);
    }
}
