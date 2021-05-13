package cn.edu.sdu.sdudoc.controller;

import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.util.PageInfo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

    @RequestMapping(value = "/insert_sdudoc", method = RequestMethod.POST, produces = "application/json")
    public String insertSdudoc(@RequestBody JSONObject json) throws SolrServerException, IOException {
        return solrService.insertSdudoc(json);
    }

    @RequestMapping(value = "/getSVG", method = RequestMethod.POST)
    public String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException {
        return solrService.getSVG(aid, keyword, width, height);
    }

    @RequestMapping(value = "/getSVG2", method = RequestMethod.POST)
    public String getSVG(String aid, String keyword, String width) throws SolrServerException, IOException {
        return solrService.getSVG(aid, keyword, width);
    }

}
