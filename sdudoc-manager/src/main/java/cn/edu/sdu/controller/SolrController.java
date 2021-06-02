package cn.edu.sdu.controller;

import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.result.QueryResults;
import cn.edu.sdu.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * @param sort 排序字段 格式：字段 asc\desc 字段与排序规则用空格分割
     * @param start 起始位置
     * @param rows 返回条数
     * @param fields 返回字段 格式：字段 字段
     * @param filterQueries 补充查询条件 格式：字段:keyword
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public QueryResults query(String coreName,
                              String defaultField,
                              String query,
                              String sort,
                              Integer start,
                              Integer rows,
                              String fields,
                              String... filterQueries) throws SolrServerException, IOException {
        return solrService.query(coreName, defaultField, query, sort, start, rows, fields, filterQueries);
    }

    /**
     * 查询方法
     * @param coreName 查询的solr的core名称
     * @param defaultField 默认查询字段
     * @param query 查询关键词
     * @param sort 排序字段 格式：字段 asc\desc 字段与排序规则用空格分割
     * @param start 起始位置
     * @param rows 返回条数
     * @param fields 返回字段 格式：字段 字段
     * @param filterQueries 补充查询条件 格式：字段:keyword
     */
    @RequestMapping(value = "/groupQuery", method = RequestMethod.POST)
    @ResponseBody
    public List<GroupCommand> groupQuery(String coreName,
                                         String defaultField,
                                         String query,
                                         String sort,
                                         Integer start,
                                         Integer rows,
                                         String group,
                                         String fields,
                                         String... filterQueries) throws SolrServerException, IOException {
        return solrService.groupQuery(coreName, defaultField, query, sort, start, rows, group, fields, filterQueries);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String coreName, String id) throws SolrServerException, IOException, HttpStatusException {
        return solrService.delete(coreName, id);
    }

    @RequestMapping(value = "/deleteMany", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMany(String coreName, String _id) throws SolrServerException, IOException, HttpStatusException {
        return solrService.deleteMany(coreName, _id);
    }
}
