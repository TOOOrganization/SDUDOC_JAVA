package cn.edu.sdu;

import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.service.impl.DocServiceImpl;
import cn.edu.sdu.util.OkHttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ArticleTest {

    @Autowired
    DocServiceImpl docServiceImpl;

    @Test
    public void insert() throws HttpStatusException {
        Map<String, Object> map = new HashMap<>();
        map.put("dms_article", 111);
        map.put("dms_character", 222);
        map.put("dms_word", 333);
        JSONObject j = new JSONObject(map);
        String response = OkHttpUtil.doPost("http://localhost:8081/audit/insert", j.toJSONString(), null, "POST");
        System.out.println(response);
    }
}
