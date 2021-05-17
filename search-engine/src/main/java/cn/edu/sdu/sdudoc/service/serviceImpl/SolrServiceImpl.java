package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.common.JsonParser;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsWord;
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
import java.util.Collection;
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

//    @Override
//    public JSONArray query(String corename,String field, String keyword) throws SolrServerException, IOException {
//        System.out.println("1");
//        switch(corename){
//            case "dms_article":
//                return queryArticle(corename, field, keyword);
//            default:
//                return queryOne(corename, field, keyword);
//        }
//    }
//
//    @Override
//    public JSONArray query(String corename,String field, String keyword, String id) throws SolrServerException, IOException {
//        System.out.println("2");
//        switch(corename){
//            case "dms_character":
//                return queryCharacter(corename, field, keyword, id);
//            default:
//                return queryOne(corename, field, keyword);
//        }
//    }

    @Override
    public SolrDocumentList query(String corename, String defaultfield, String query, String sort,
                                  int start, int rows, String... filterqueries) throws SolrServerException, IOException {

        SolrQuery solrQuery=new SolrQuery();

        //设置默认查询字段与查询关键词
        solrQuery.set("df", defaultfield);
        solrQuery.setQuery((defaultfield.equals("")) ? "*" : query);

        //排序
        if(!sort.equals("")){
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

        //起始位置与行数
        solrQuery.setStart(start);
        solrQuery.setRows((rows == -1) ? Integer.MAX_VALUE : rows);

        //其余条件
        solrQuery.setFilterQueries(filterqueries);

        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(corename,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results);

        return results;
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
//        solrQuery.setr
        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(corename,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results);
        JSONArray jsonArray = new JSONArray();
        for (SolrDocument document:results) {
//            System.out.println(document);
            jsonArray.add(document);
        }
        return jsonArray;
    }

    public JSONArray queryArticle(String corename,String field, String keyword) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setRows(Integer.MAX_VALUE);
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
        System.out.println(String.valueOf(query));
        solrQuery.setRows(Integer.MAX_VALUE);
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

    public JSONArray queryWord(String corename,String field, String keyword, String article) throws SolrServerException, IOException {
        System.out.println(field+":"+keyword);
        SolrQuery solrQuery=new SolrQuery();
        StringBuilder query = new StringBuilder();
        query.append("article:").append(article).append(" && (").append(field).append(":").append(keyword).append(")");
        System.out.println(String.valueOf(query));
        solrQuery.setRows(Integer.MAX_VALUE);
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
        Collection<DmsCharacter> characterss = new ArrayList<DmsCharacter>();
        int count = 0;
        for(HashMap h : characters){
            characterss.add(m.saveCharacter(h,article));
        }
        //在mongodb插入词
        List<HashMap> words = m.getWord(object);
        Collection<DmsWord> wordss = new ArrayList<DmsWord>();
        count = 0;
        for(HashMap h : words){
            if(((List)h.get("string")).size() == 1)
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

    private ArrayList<HashMap<String, String>> getPageInfo(ArrayList list){
        ArrayList<HashMap<String, String>> output = new ArrayList<>();
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


        ArrayList<HashMap<String, String>> list = this.getPageInfo((ArrayList)article.get("page"));
        ArrayList<PageInfo> page_list = new ArrayList<>();
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

//    @Override
//    public String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException {
//
//        //获取aid对应的文章
//        JSONArray article_array = this.queryArticle("dms_article","_id", aid);
//        SolrDocument article = (SolrDocument) article_array.get(0);
//
//        //得到文章对应的page列表
//        ArrayList<HashMap<String, String>> list = this.getPageInfo((ArrayList)article.get("page"));
//        ArrayList<PageInfo> page_list = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            PageInfo info = new PageInfo(list.get(i));
//            //进行缩放的操作
//            info.setScale(width, height);
//            page_list.add(info);
//        }
//
//        //每一个字的信息
//        JSONArray char_array = this.queryCharacter("dms_character","character", keyword, aid);
//        List<SolrDocument> char_list = new ArrayList<>();
//        for(Object o : char_array){
//            char_list.add((SolrDocument) o);
//        }
//        for(SolrDocument s : char_list){
//            String page = (String)((ArrayList)s.get("page")).get(0);
//            ArrayList<String> position = (ArrayList)s.get("position");
//            for(PageInfo page_info : page_list){
//                if(page_info.getId().equals(page)){
//                    page_info.addPolygon(position);
//                }
//            }
//        }
//        System.out.println(page_list.toString());
//        return page_list.toString();
//    }

    @Override
    public String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException {

        //获取aid对应的文章
        JSONArray article_array = this.queryArticle("dms_article","_id", aid);
        SolrDocument article = (SolrDocument) article_array.get(0);

        //得到文章对应的page列表
        ArrayList<HashMap<String, String>> list = this.getPageInfo((ArrayList)article.get("page"));
        ArrayList<PageInfo> page_list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            PageInfo info = new PageInfo(list.get(i));
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
            for(SolrDocument s:word_list){
                ArrayList<String> point_list = (ArrayList) s.get("position");
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
            JSONArray char_array = this.queryCharacter("dms_character","character", keyword, aid);
            List<SolrDocument> char_list = new ArrayList<>();
            for(Object o : char_array){
                char_list.add((SolrDocument) o);
            }
            for(SolrDocument s : char_list){
                String page = (String)((ArrayList)s.get("page")).get(0);
                ArrayList<String> position = (ArrayList)s.get("position");
                for(PageInfo page_info : page_list){
                    if(page_info.getId().equals(page)){
                        page_info.addPolygon(position);
                    }
                }
            }
        }

        System.out.println(page_list.toString());
        return page_list.toString();
    }

    public String getSVG_char(String aid, String keyword, String width, String height){
        return "";
    }

}
