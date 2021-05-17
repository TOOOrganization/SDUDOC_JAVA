package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.common.JsonParser;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsWord;
import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.util.PageInfo;
import cn.edu.sdu.sdudoc.util.ParserObject;
import cn.edu.sdu.sdudoc.util.SolrInput;
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
    public SolrDocumentList query(String coreName,
                                  String defaultField,
                                  String query,
                                  String sort,
                                  Integer start,
                                  Integer rows,
                                  String... filterQueries) throws SolrServerException, IOException {

        SolrQuery solrQuery = new SolrQuery();

        // 设置默认查询字段与查询关键词
        solrQuery.set("df", defaultField);
        if (defaultField == null)
            solrQuery.setQuery("*:*");
        else
            solrQuery.setQuery((defaultField.equals("")) ? "*" : query);

        // 排序
        if (sort != null && !sort.equals("")) {
            String[] sorts = sort.split(" ");
            switch (sorts[1]){
                case "asc":
                    solrQuery.setSort(sorts[0], SolrQuery.ORDER.asc);
                    break;
                case "desc":
                    solrQuery.setSort(sorts[0], SolrQuery.ORDER.desc);
                    break;
                default:
                    break;
            }
        }

        // 起始位置与行数
        try{
            solrQuery.setStart(start);
        }catch (NullPointerException e){
            solrQuery.setStart(0);
        }
        try{
            solrQuery.setRows((rows == -1) ? Integer.MAX_VALUE : rows);
        }catch (NullPointerException e){
            solrQuery.setRows(Integer.MAX_VALUE);
        }

        //其余条件
        solrQuery.setFilterQueries(filterQueries);

        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(coreName,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results);

        return results;
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

    @Override
    public String insertSdudoc(JSONObject json) throws SolrServerException, IOException {
        Map<String, Object> object = JSONObject.parseObject(JSON.toJSONString(json));
        //在mongodb插入文章，获取文章id
        DmsArticle article = m.saveArticle(object);
        if(article == null){
            return "错误，文章已存在";
        }
        //在mysql插入文章头信息
        m.saveArticleHead(object,article.get_id());
        //在mongodb插入字
        List<Map<String, Object>> characters = m.getCharacter(object);
        Collection<DmsCharacter> characterss = new ArrayList<>();

        for(Map<String, Object> h : characters){
            characterss.add(m.saveCharacter(h,article));
        }
        //在mongodb插入词
        List<Map<String, Object>> words = m.getWord(object);
        Collection<DmsWord> wordss = new ArrayList<>();

        for(Map<String, Object> h : words){
            if(m.getList(h, "string").size() == 1)
                continue;
            wordss.add(m.saveWord(h,article));
        }
        //article存入solr
        solrInput.addData("dms_article", article);
        //character存入solr
        solrInput.addData("dms_character", characterss);
        //word存入solr
        solrInput.addData("dms_word", wordss);
        return "文章添加成功";
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


    @Override
    public String getSVG(String aid, String keyword, String width) throws SolrServerException, IOException {
        JSONArray article_array = this.queryArticle("dms_article","_id", aid);
        SolrDocument article = (SolrDocument) article_array.get(0);

        List<Object> listObject = JSONObject.parseArray(JSON.toJSONString(article.get("page")));
        List<HashMap<String, String>> list = this.getPageInfo(o2s(listObject));
        ArrayList<PageInfo> page_list = new ArrayList<>();
        for (HashMap<String, String> stringStringHashMap : list) {
            PageInfo info = new PageInfo(stringStringHashMap);
            info.setScale(width, (Double.parseDouble(width) / info.getWidth() * info.getHeight()) + "");
            page_list.add(info);
        }

        solrQueryCharacter(aid, keyword, article, page_list);

        return page_list.toString();
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
                    page_info.addPolygon(position);
                }
            }
        }
    }

    @Override
    public String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException {

        //获取aid对应的文章
        JSONArray article_array = this.queryArticle("dms_article","_id", aid);
        SolrDocument article = (SolrDocument) article_array.get(0);

        //得到文章对应的page列表
        List<HashMap<String, String>> list = this.getPageInfo(o2s(JSONObject.parseArray(JSON.toJSONString(article.get("page")))));
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
                                page_info.addPolygon(position);
                            }
                        }
                    }
                }
            }
        }else{
            //每一个字的信息
            solrQueryCharacter(aid, keyword, article, page_list);
        }

        return page_list.toString();
    }

    private List<String> o2s(List<Object> list) {
        return (List<String>) (List) list;
    }
}
