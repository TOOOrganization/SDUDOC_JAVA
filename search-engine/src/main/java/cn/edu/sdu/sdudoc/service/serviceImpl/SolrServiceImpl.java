package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.common.JsonParser;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.util.PageInfo;
import cn.edu.sdu.sdudoc.util.ParserObject;
import cn.edu.sdu.sdudoc.util.SolrInput;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    ParserObject m;

    @Autowired
    SolrInput solrInput;

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
        query.append("articles:").append(article).append(" && (");
        for(int i=0;i<keyword.length();i++){
            query.append(field).append(":").append(keyword.charAt(i));
            if(i<keyword.length()-1){
                query.append(" || ");
            }
        }
        query.append(")");
        System.out.println(String.valueOf(query));
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

    @Override
    public String insertSdudoc(JSONObject json) throws SolrServerException, IOException {
        JsonParser parser = new JsonParser(json.toString());
        HashMap object = (HashMap) parser.parse();
        //在mongodb插入文章，获取文章id
        DmsArticle article = m.saveArticle(object);
        if(article == null){
            return "错误，文章已存在";
        }
        //在mysql插入文章头信息
        m.saveArticleHead(object,article.get_id());
        //在mongodb插入字
        List<HashMap> characters = m.getCharacter(object);
        DmsCharacter[] characterss = new DmsCharacter[characters.size()];
        int count = 0;
        for(HashMap h : characters){
            characterss[count++] = m.saveCharacter(h,article);
        }
        //article存入solr
        solrInput.addData(article);
        //character存入solr
        for(DmsCharacter c : characterss){
            solrInput.addData(c);
        }
        return "文章添加成功";
    }

    private ArrayList<HashMap<String, String>> getPageInfo(ArrayList list){
        ArrayList<HashMap<String, String>> output = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < list.size(); i++) {
            String str = (String)list.get(i);
            HashMap<String, String> map = new HashMap<String, String>();
            String key = "", value = "";
            boolean status = false;
            for(int j = 0; j < str.length(); j ++){
                char c = str.charAt(j);
                switch(c){
                    case '{':
                        break;
                    case '=':
                        if(status)
                            value += c;
                        else
                            status = true;
                        break;
                    case '}':
                        map.put(key, value);
                        break;
                    case ',':
                        if(str.charAt(j + 1) == ' ')
                            j += 1;
                        status = false;
                        map.put(key, value);
                        key = "";
                        value = "";
                        break;
                    default:
                        if(status)
                            value += c;
                        else
                            key += c;
                }
            }
            output.add(map);
        }
        return output;
    }


    @Override
    public String getSVG(String aid, String keyword, String width) throws SolrServerException, IOException {
        JSONArray article_array = this.queryArticle("dms_article","_id", aid);
        SolrDocument article = (SolrDocument) article_array.get(0);

        JSONObject article_map =  article_array.getJSONObject(0);
        JSONArray page_array = article_map.getJSONArray("page");

        ArrayList<HashMap<String, String>> list = this.getPageInfo((ArrayList)article.get("page"));
        ArrayList<PageInfo> page_list = new ArrayList<PageInfo>();
        for (int i = 0; i < list.size(); i++) {
            PageInfo info = new PageInfo(list.get(i));
            info.setScale(width, (Double.parseDouble(width)/info.getWidth() * info.getHeight())+"");
            page_list.add(info);
        }

        JSONArray char_array = this.queryCharacter("dms_character","character", keyword, aid);
        List<SolrDocument> char_list = new ArrayList<>();
        for(Object o : char_array){
            char_list.add((SolrDocument) o);
        }
        for(SolrDocument s : char_list){
            String page = (String)((ArrayList)s.get("page")).get(0);
            ArrayList<String> position = (ArrayList)s.get("position");
//            System.out.println(position);
//            System.out.println(position.size());
            for(PageInfo page_info : page_list){
                if(page_info.getId().equals(page)){
                    page_info.addPolygon(position);
                }
            }
        }
//        for(PageInfo page_info : page_list){
//            System.out.println(page_info);
//        }

        System.out.println(page_list.toString());

        return page_list.toString();
    }

}
