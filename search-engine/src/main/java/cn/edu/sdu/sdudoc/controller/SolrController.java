package cn.edu.sdu.sdudoc.controller;

import cn.edu.sdu.sdudoc.service.SolrService;
import com.alibaba.fastjson.JSONArray;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/solr")
public class SolrController {

    @Autowired
    private SolrService solrService;

    @ResponseBody
    @RequestMapping("/query_head")
    public JSONArray queryHead(String corename,String field,String keyword) throws IOException, SolrServerException {
        return solrService.queryHead(corename,field, keyword);
    }

}
