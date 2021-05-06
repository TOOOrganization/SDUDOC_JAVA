package cn.edu.sdu.sdudoc.sdudocmysql.controller;

import cn.edu.sdu.sdudoc.sdudocmysql.service.SolrService;
import com.alibaba.fastjson.JSONArray;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/solr")
public class SolrController {

    @Autowired
    private SolrService solrService;

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public JSONArray query(String corename,String field,String keyword) throws IOException, SolrServerException {
        return solrService.query(corename,field, keyword);
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public JSONArray query(String corename,String field,String keyword,String id) throws IOException, SolrServerException {
        return solrService.query(corename, field, keyword, id);
    }

}
