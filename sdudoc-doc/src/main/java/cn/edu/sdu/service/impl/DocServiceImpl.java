package cn.edu.sdu.service.impl;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.service.DocService;
import cn.edu.sdu.util.OkHttpUtil;
import cn.edu.sdu.util.ParserObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class DocServiceImpl implements DocService {

    @Autowired
    ParserObject m;


    @Override
    public CommonResult<String> insertSdudoc(JSONObject json) throws SolrServerException, IOException {
        Map<String, Object> object = JSONObject.parseObject(JSON.toJSONString(json));
        DmsArticle article;
        try{
            //在mongodb插入文章，获取文章id
            article = m.saveArticle(object);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed("插入article失败");
        }

        if(article == null){
            return CommonResult.failed("错误，文章已存在");
        }
        try{
            m.saveArticleHead(object, article.get_id());
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed("写入MySQL失败");
        }
        List<Map<String, Object>> characters;
        List<Map<String, Object>> words = new ArrayList<>();
        try{
            //在mongodb插入字
            characters = m.getCharacter(object);
        }catch (NullPointerException e){
            e.printStackTrace();
            return CommonResult.failed("未插入字");
        }

        try{
            //在mongodb插入词
            words = m.getWord(object);
        }catch (Exception e){
            e.printStackTrace();
        }

        Collection<DmsCharacter> characterss = new ArrayList<>();

        for(Map<String, Object> h : characters){
            characterss.add(m.saveCharacter(h,article));
        }

        Collection<DmsWord> wordss = new ArrayList<>();

        for(Map<String, Object> h : words){
            if(m.getList(h, "string").size() == 1)
                continue;
            wordss.add(m.saveWord(h,article));
        }
        try {
            Map<String, String> map = new HashMap<>();
            map.put("core", "dms_article");
            map.put("o", JSON.toJSONString(article));
            System.out.println(map);
            OkHttpUtil.doPost("http://211.87.232.198:8081/search-engine/audit/insert", map, "POST");

            map.clear();
            map.put("core", "dms_character");
            map.put("o", JSON.toJSONString(characterss));
            OkHttpUtil.doPost("http://211.87.232.198:8081/search-engine/audit/insert", map, "POST");

            map.clear();
            map.put("core", "dms_word");
            map.put("o", JSON.toJSONString(wordss));
            OkHttpUtil.doPost("http://211.87.232.198:8081/search-engine/audit/insert", map, "POST");
        } catch (HttpStatusException e) {
            e.printStackTrace();
        }

        return CommonResult.success("文章添加mongoDB成功");
    }
}
