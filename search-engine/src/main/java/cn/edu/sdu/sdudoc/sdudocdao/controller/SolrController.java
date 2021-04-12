package cn.edu.sdu.sdudoc.sdudocdao.controller;

import cn.edu.sdu.sdudoc.sdudocdao.service.SolrService;
import com.alibaba.fastjson.JSONArray;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class SolrController {

    @Autowired
    private SolrService solrService;

    @RequestMapping("/solr/queryHead")
    @ResponseBody
    public JSONArray queryHead(String type,String keyword) throws IOException, SolrServerException {
        return solrService.queryHead(type,keyword);
    }

}
