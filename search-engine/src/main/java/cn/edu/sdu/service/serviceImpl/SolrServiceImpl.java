package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.component.SolrQueryBuilder;
import cn.edu.sdu.result.QueryResults;
import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.service.SolrService;
import cn.edu.sdu.util.PageInfo;
import cn.edu.sdu.util.ParserObject;
import cn.edu.sdu.util.SolrInput;
import cn.edu.sdu.util.OkHttpUtil;
import com.alibaba.fastjson.JSON;
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
import java.util.*;

@Component
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    ParserObject m;

    @Autowired
    SolrInput solrInput;

    @Override
    public QueryResults query(String coreName,
                              String defaultField,
                              String query,
                              String sortField,
                              String order,
                              Integer start,
                              Integer rows,
                              String mode,
                              String... filterQueries) throws SolrServerException, IOException {

        SolrQueryBuilder solrQueryBuilder = new SolrQueryBuilder();
        SolrQuery solrQuery = solrQueryBuilder.setDefaultField(defaultField)
                .setQuery(query)
                .setSortField(sortField)
                .setOrder(order)
                .setStart(start)
                .setRows(rows)
                .setMode(mode)
                .setFilterQueries(filterQueries)
                .build();

        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(coreName,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results.getNumFound());

        QueryResults queryResults = new QueryResults(results.getNumFound(), results);
        System.out.println(queryResults);

        return queryResults;
    }

    public JSONArray queryOne(String coreName,String field, String keyword) throws SolrServerException, IOException{
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        //查询的属性必须在solr库中有定义 ，否则会报错：
        //Error from server at http://192.168.65.128:8080/solr: undefined field gnames
        //只针对于gname属性进行查询
        //solrQuery.setQuery("gname:苹果手机");
        //针对多属性进行查询(注意多条件连接时，之间要有空格)
        //solrQuery.setQuery("gname:手机 || ginfo:苹果");
        solrQuery.setQuery(field+":"+keyword);
//        solrQuery.setr
        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(coreName,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results);
        JSONArray jsonArray = new JSONArray();
        //            System.out.println(document);
        jsonArray.addAll(results);
        return jsonArray;
    }

    public JSONArray queryArticle(String coreName,String field, String keyword) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setRows(Integer.MAX_VALUE);
        solrQuery.setQuery(field+":"+keyword);
        return solrQueryCoreName(coreName, solrQuery);
    }

    public JSONArray queryCharacter(String coreName,String field, String keyword, String article) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        StringBuilder query = new StringBuilder();
        query.append("article:").append(article).append(" && (");
        for(int i=0;i<keyword.length();i++){
            char c= keyword.charAt(i);
            if(c == ' ')
                continue;
            query.append(field).append(":").append(c);
            if(i<keyword.length()-1){
                query.append(" || ");
            }
        }
        query.append(")");
        solrQuery.setRows(Integer.MAX_VALUE);
        solrQuery.setQuery(String.valueOf(query));
        return solrQueryCoreName(coreName, solrQuery);
    }

    private JSONArray solrQueryCoreName(String coreName, SolrQuery solrQuery) throws SolrServerException, IOException {
        QueryResponse queryResponse = solrClient.query(coreName,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        JSONArray jsonArray = new JSONArray();
        for (SolrDocument document:results) {
            System.out.println(document);
            jsonArray.add(document);
        }
        return jsonArray;
    }

    public JSONArray queryWord(String coreName,String field, String keyword, String article) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setRows(Integer.MAX_VALUE);
        solrQuery.setQuery("article:" + article + " && (" + field + ":" + keyword + ")");
        return solrQueryCoreName(coreName, solrQuery);
    }


    private List<HashMap<String, String>> getPageInfo(List<String> list){
        List<HashMap<String, String>> output = new ArrayList<>();
        for (String str : list) {
            HashMap<String, String> map = new HashMap<>();
            String key = "", value = "";
            boolean status = false;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '{':
                        break;
                    case '=':
                        if (status)
                            value += c;
                        else
                            status = true;
                        break;
                    case '}':
                        map.put(key, value);
                        break;
                    case ',':
                        if (str.charAt(j + 1) == ' ')
                            j += 1;
                        status = false;
                        map.put(key, value);
                        key = "";
                        value = "";
                        break;
                    default:
                        if (status)
                            value += c;
                        else
                            key += c;
                }
            }
            output.add(map);
        }
        return output;
    }


    private void solrQueryCharacter(String aid, String keyword, SolrDocument article, ArrayList<PageInfo> page_list) throws SolrServerException, IOException {
        JSONArray char_array = this.queryCharacter("dms_character","character", keyword, aid);
        List<SolrDocument> char_list = new ArrayList<>();
        for(Object o : char_array){
            char_list.add((SolrDocument) o);
        }
        for(SolrDocument s : char_list){
            String page = (String)(JSONObject.parseArray(JSON.toJSONString(s.get("page")))).get(0);
            List<String> position = o2s(JSONObject.parseArray(JSON.toJSONString(s.get("position"))));

            for(PageInfo page_info : page_list){
                if(page_info.getId().equals(page)){
                    page_info.addCharPolygon(position);
                }
            }
        }
    }

    @Override
    public String getSVG(String aid, String keyword, String width, String height, String mode) throws SolrServerException, IOException {

        //获取aid对应的文章
        JSONArray article_array = this.queryArticle("dms_article","_id", aid);
        SolrDocument article = (SolrDocument) article_array.get(0);

        //得到文章对应的page列表
        List<HashMap<String, String>> list = this.getPageInfo(o2s(JSONObject.parseArray(JSON.toJSONString(article.get("page")))));
        list.remove(list.size()-1);
        ArrayList<PageInfo> page_list = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : list) {
            PageInfo info = new PageInfo(stringStringHashMap);
            //进行缩放的操作
            info.setScale(width, height);
            page_list.add(info);
        }

        //获取词的信息
        JSONArray word_array = this.queryWord("dms_word","word", keyword, aid);
        if(!word_array.isEmpty()){
            List<SolrDocument> word_list = new ArrayList<>();
            for(Object o : word_array){
                word_list.add((SolrDocument) o);
            }
            for(SolrDocument s : word_list){
                List<String> point_list = o2s(JSONObject.parseArray(JSON.toJSONString(s.get("position"))));
                for(String p : point_list){
                    String[] point_array = p.split("\\|");
                    String page = point_array[0];
                    for(int i = 1; i < point_array.length; i++){
                        ArrayList<String> position = new ArrayList<>();
                        String[] points = point_array[i].split(";");
                        for(String point : points){
                            String[] point_i = point.split(":");
                            position.add(point_i[0]);
                            position.add(point_i[1]);
                        }
                        for(PageInfo page_info : page_list){
                            if(page_info.getId().equals(page)){
                                page_info.addWordPolygon(position);
                            }
                        }
                    }
                }
            }
        }else if (!mode.equals("precise")){
            //每一个字的信息
            solrQueryCharacter(aid, keyword, article, page_list);
        }

        System.out.println(page_list);

        return page_list.toString();
    }

    @Override
    public String getPNG(String pid) throws HttpStatusException {
        return "data:image/png;base64," + OkHttpUtil.doGet("http://211.87.232.199:8080/mysql/img/get_by_id?id=" + pid, "GET");
    }

    @Override
    public List<String> getPNGs(String pids) throws HttpStatusException {
        List<String> result = new ArrayList<>();
        List<String> pidList = JSONArray.parseArray(pids, String.class);
        for (String pid : pidList){
            result.add("data:image/png;base64," + OkHttpUtil.doGet("http://211.87.232.199:8080/mysql/img/get_by_id?id=" + pid, "GET"));
        }
        return result;
    }

    private List<String> o2s(List<Object> list) {
        return (List<String>) (List) list;
    }
}
