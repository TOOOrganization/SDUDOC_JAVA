package cn.edu.sdu.controller;

import cn.edu.sdu.result.QueryResults;
import cn.edu.sdu.service.SolrService;
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

    /**
     * 查询方法
     * @param coreName 查询的solr的core名称
     * @param defaultField 默认查询字段
     * @param query 查询关键词
     * @param sortField 排序字段 格式：字段 asc\desc 字段与排序规则用空格分割
     * @param order 排序规则
     * @param start 起始位置
     * @param rows 返回条数
     * @param filterQueries 补充查询条件 格式：字段:keyword
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public QueryResults query(String coreName,
                              String defaultField,
                              String query,
                              String sortField,
                              String order,
                              Integer start,
                              Integer rows,
                              String... filterQueries) throws SolrServerException, IOException {
        return solrService.query(coreName, defaultField, query, sortField, order, start, rows, filterQueries);
    }
}
