package cn.edu.sdu.sdudoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhengja@dist.com.cn
 * @data 2019/8/15 15:43
 */
@RequestMapping(value = "rest/solr")
@RestController
@Api(tags = {"SolrController"},description = "Solr 全文检索")
public class SolrController {

    @Autowired
    private SolrClient client;

    @ApiOperation(value = "添加文档内容",notes = "向文档中添加域，必须有id域，域的名称必须在scheme.xml中定义",httpMethod = "GET")
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public Object validator(@ApiParam(value = "username") @RequestParam String username,
                            @ApiParam(value = "password") @RequestParam String password){
        try {
            String uid = String.valueOf(System.currentTimeMillis());

            SolrInputDocument document = new SolrInputDocument();
            document.setField("uid", uid);
            document.setField("username", username);
            document.setField("password",password);

            // 把文档对象写入索引库
            client.add("user",document);//如果配置文件中没有指定core，这个方法的第一个参数就需要指定core名称,比如client.add("core", doc);
            client.commit("user");//如果配置文件中没有指定core，这个方法的第一个参数就需要指定core名称client.commit("core");
            return uid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }


    @ApiOperation(value = "更新文档内容",notes = "更新文档内容，跟添加的区别是：id不能变，其他的可以变",httpMethod = "GET")
    @RequestMapping(value = "updateDocument",method = RequestMethod.GET)
    public Object updateDocument(@ApiParam(value = "uid") @RequestParam String uid,
                                 @ApiParam(value = "name") @RequestParam String username,
                                 @ApiParam(value = "age") @RequestParam String password) throws Exception{
        // 创建一个文档对象, 向文档中添加域，必须有id域，域的名称必须在scheme.xml中定义
        SolrInputDocument document = new SolrInputDocument();
        document.setField("uid", uid);
        document.setField("username", username);
        document.setField("password",password);
        // 把文档对象写入索引库
        client.add("user",document);
        // 提交
        client.commit("user");
        return document;
    }


    @ApiOperation(value = "全量或增量更新-数据库-没成功",notes = "java操作Solr的全量或增量更新，可以结合定时任务做定时全量或增量更新",httpMethod = "PUT")
    @RequestMapping(value = "updateSolrData",method = RequestMethod.PUT)
    public void updateSolrData() throws SolrServerException, IOException {
        //创建一个查询对象
        SolrQuery solrQuery = new SolrQuery();

        //增量更新全部完成；注意这里entity的值为solr-data-config.xml里entity标签里的name值
        final String SOLR_DELTA_PARAM = "/dataimport?command=delta-import&entity=order_info&clean=false&commit=true";
        //全量更新全部完成
        final String SOLR_FULL_PARAM = "/dataimport?command=full-import&entity=order_info&clean=true&commit=true";
        //设置更新方式
        solrQuery.setRequestHandler(SOLR_DELTA_PARAM);

        // 执行查询
        QueryResponse query = client.query("user",solrQuery);

        //提交
        client.commit("user");

    }

    @ApiOperation(value = "查询文档内容",notes = "查询文档内容",httpMethod = "GET")
    @RequestMapping(value = "queryDocument",method = RequestMethod.GET)
    public Object queryDocument(@ApiParam(value = "条件",defaultValue = "*:*") @RequestParam String condition,
                                @ApiParam(value = "连接文件夹 默 core",defaultValue = "user") @RequestParam String collection,
                                @ApiParam(value = "分页起始 默 1",defaultValue = "1") @RequestParam Integer pageStart,
                                @ApiParam(value = "分页结束 默 10",defaultValue = "10") @RequestParam Integer pageEnd) throws Exception {
        // 创建一个查询条件
        SolrQuery solrQuery = new SolrQuery();
        // 设置查询条件
        solrQuery.setQuery(condition);
        // 设置分页
        solrQuery.setStart(pageStart);
        solrQuery.setRows(pageEnd);
        // 执行查询
        QueryResponse query = client.query(collection,solrQuery);
        // 取查询结果
        SolrDocumentList solrDocumentList = query.getResults();

        System.out.println("总记录数：" + solrDocumentList.getNumFound());

        for (SolrDocument sd : solrDocumentList) {
            System.out.println(sd.get("uid"));
            System.out.println(sd.get("username"));
            System.out.println(sd.get("password"));
        }
        return solrDocumentList;
    }


    @ApiOperation(value = "删除文档",notes = "删除文档",httpMethod = "DELETE")
    @RequestMapping(value = "deteleDocument",method = RequestMethod.DELETE)
    public Object deteleDocument(@ApiParam(value = "连接文件夹 默 core" ,defaultValue = "user") @RequestParam String collection,
                                 @ApiParam(value = "idStr") @RequestParam String idStr) throws Exception {
        // 根据id删除
        UpdateResponse response = client.deleteById(collection, idStr);
        // 根据条件删除
        // httpSolrServer.deleteByQuery("");
        // 提交
        client.commit(collection);

        return response;
    }

}
