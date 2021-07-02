package cn.edu.sdu.search.controller;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.search.service.CloudAuditService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/audit")
public class CloudAuditController {

    @Autowired
    private CloudAuditService cloudAuditService;


    /**
     *
     * @param core core名称
     * @param o 123
     * @return
     * @throws SolrServerException
     * @throws IOException
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insertSolr(String core, String o) throws SolrServerException, IOException {
        System.out.println(o);
        switch (core){
            case "dms_article" :
                return cloudAuditService.insertSolr(core, JSON.parseObject(o, DmsArticle.class));
            case "dms_character":
                List<DmsCharacter> ja_character = JSONArray.parseArray(o,DmsCharacter.class);
                Collection<DmsCharacter> characters = new ArrayList<>();
                for(Object j : ja_character){
                    characters.add((DmsCharacter) j);
                }
                return cloudAuditService.insertSolr(core, characters);
            case "dms_word":
                List<DmsWord> ja_word = JSONArray.parseArray(o,DmsWord.class);
                Collection<DmsWord> words = new ArrayList<>();
                for(Object j : ja_word){
                    words.add((DmsWord) j);
                }
                return cloudAuditService.insertSolr(core, words);
            default:
                return "warning";
        }
    }

}
