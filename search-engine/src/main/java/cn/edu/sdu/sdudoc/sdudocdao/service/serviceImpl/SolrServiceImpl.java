package cn.edu.sdu.sdudoc.sdudocdao.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocdao.service.ArticleService;
import cn.edu.sdu.sdudoc.sdudocdao.service.SolrService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrClient solrClient;

    @Override
    public JSONArray queryHead(String type, String keyword) throws SolrServerException, IOException {
        System.out.println(type+":*"+keyword+"*");
        SolrQuery solrQuery=new SolrQuery();
        //查询的属性必须在solr库中有定义 ，否则会报错：
        //Error from server at http://192.168.65.128:8080/solr: undefined field gnames
        //只针对于gname属性进行查询
        //solrQuery.setQuery("gname:苹果手机");
        //针对多属性进行查询(注意多条件连接时，之间要有空格)
        //solrQuery.setQuery("gname:手机 || ginfo:苹果");
        solrQuery.setQuery(type+":*"+keyword+"*");
        QueryResponse queryResponse = solrClient.query(solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        JSONArray jsonArray = new JSONArray();
        for (SolrDocument document:results) {
            JSONObject json =new JSONObject();
            json.put("aid", document.get("aid"));
            json.put("title", document.get("title"));
            json.put("articleAuthor", document.get("articleAuthor"));
            json.put("dynasty", document.get("dynasty"));
            json.put("bookname", document.get("bookname"));
            System.out.println(json);
            jsonArray.add(json);
        }
        return jsonArray;
    }
}
