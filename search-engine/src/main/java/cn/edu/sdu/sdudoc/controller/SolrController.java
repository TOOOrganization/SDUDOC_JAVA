package cn.edu.sdu.sdudoc.controller;

import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.util.PageInfo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
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


//    @RequestMapping(value = "/query",method = RequestMethod.POST)
//    @ResponseBody
//    public JSONArray query(String corename,String field,String keyword) throws IOException, SolrServerException {
//        return solrService.query(corename, field, keyword, id);
//    }

    /**
     * 查询方法
     * @param coreName 查询的solr的core名称
     * @param defaultField 默认查询字段
     * @param query 查询关键词
     * @param sort 排序 格式：字段 asc\desc 字段与排序规则用空格分割
     * @param start 起始位置
     * @param rows 返回条数
     * @param filterQueries 补充查询条件 格式：字段:keyword
    */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public SolrDocumentList query(String coreName, String defaultField, String query, String sort,
                                  Integer start, Integer rows, String... filterQueries) throws SolrServerException, IOException {
        return solrService.query(coreName, defaultField, query, sort, start, rows, filterQueries);
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
