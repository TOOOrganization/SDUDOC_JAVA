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
public class SolrController {

    @Autowired
    private SolrService solrService;

    @RequestMapping("/solr/queryHead")
    @ResponseBody
    public JSONArray queryHead(String type,String keyword) throws IOException, SolrServerException {
        return solrService.queryHead(type,keyword);
    }

}
