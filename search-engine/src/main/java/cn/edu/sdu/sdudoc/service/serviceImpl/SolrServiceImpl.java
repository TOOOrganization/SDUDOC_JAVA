package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.service.SolrService;
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
    public JSONArray query(String corename,String field, String keyword) throws SolrServerException, IOException {
        System.out.println("1");
        switch(corename){
            case "dms_article":
                return queryArticle(corename, field, keyword);
            default:
                return queryOne(corename, field, keyword);
        }
    }

    @Override
    public JSONArray query(String corename,String field, String keyword, String id) throws SolrServerException, IOException {
        System.out.println("2");
        switch(corename){
            case "dms_character":
                return queryCharacter(corename, field, keyword, id);
            default:
                return queryOne(corename, field, keyword);
        }
    }

    public JSONArray queryOne(String corename,String field, String keyword) throws SolrServerException, IOException{
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        //查询的属性必须在solr库中有定义 ，否则会报错：
        //Error from server at http://192.168.65.128:8080/solr: undefined field gnames
        //只针对于gname属性进行查询
        //solrQuery.setQuery("gname:苹果手机");
        //针对多属性进行查询(注意多条件连接时，之间要有空格)
        //solrQuery.setQuery("gname:手机 || ginfo:苹果");
        solrQuery.setQuery(field+":"+keyword);
        QueryResponse queryResponse = solrClient.query(corename,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        JSONArray jsonArray = new JSONArray();
        for (SolrDocument document:results) {
            System.out.println(document);
            jsonArray.add(document);
        }
        return jsonArray;
    }

    public JSONArray queryArticle(String corename,String field, String keyword) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setQuery(field+":"+keyword);
        QueryResponse queryResponse = solrClient.query(corename,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        JSONArray jsonArray = new JSONArray();
        for (SolrDocument document:results) {
            System.out.println(document);
            jsonArray.add(document);
        }
        return jsonArray;
    }

    public JSONArray queryCharacter(String corename,String field, String keyword, String article) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        StringBuilder query = new StringBuilder();
        query.append("articles:").append(article).append(" && ");
        for(int i=0;i<keyword.length();i++){
            query.append(field).append(":").append(keyword.charAt(i));
            if(i<keyword.length()-1){
                query.append(" || ");
            }
        }
        solrQuery.setQuery(String.valueOf(query));
        QueryResponse queryResponse = solrClient.query(corename,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        JSONArray jsonArray = new JSONArray();
        for (SolrDocument document:results) {
            System.out.println(document);
            jsonArray.add(document);
        }
        return jsonArray;
    }

}
