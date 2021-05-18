package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.controller.SolrController;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.DmsArticleRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.service.serviceImpl.SolrServiceImpl;
import cn.edu.sdu.sdudoc.util.DataOutput;
import cn.edu.sdu.sdudoc.util.SolrInput;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class ArticleTest {
    @Autowired
    private DmsArticleService dmsArticleService;

    @Autowired
    public SolrInput solrInput;

    @Autowired
    public DataOutput dataOutput;


    @Test
    public void insertOne(){
        DmsArticle article = new DmsArticle();
        article.setBookname("123456");
        dmsArticleService.save(article);
    }
//
//    @Test
//    public void insertMany(){
//        Article article1 = new Article();
//        article1.setBookname("111");
//        Article article2 = new Article();
//        article2.setBookname("222");
//        List<Article> articles = new ArrayList<>();
//        articles.add(article1);
//        articles.add(article2);
//        articleService.saveAll(articles);
//    }

    @Test
    public void findAll() {
        String s = JSONObject.toJSONString(dmsArticleService.findAll());
        System.out.println(s);
    }

    @Test
    public void findBybookname(){
        System.out.println(JSONObject.toJSONString(dmsArticleService.findBybookname("123")));
    }

    @Test
    public void findByTitle(){
        System.out.println(JSONObject.toJSONString(dmsArticleService.findByTitle("test")));
    }

    @Test
    public void findByArticleAuthor(){
        System.out.println(JSONObject.toJSONString(dmsArticleService.findByArticleAuthor("李白")));
    }


    @Resource
    private DmsArticleRepository dmsArticleRepository;

    @Test
    public void addDataDmsArticle() throws SolrServerException, IOException {
        System.out.println(dataOutput.findAllDmsArticle());
        //solrInput.addDataDmsArticle();
    }

    @Autowired
    SolrController solrController;

    @Autowired
    SolrService solrService;

    @Autowired
    SolrServiceImpl solrServiceImpl;

    @Autowired
    public SolrClient solrClient;

    @Test
    public void insert_test() throws SolrServerException, IOException {
        DmsArticle dmsArticle = new DmsArticle();
        List<Map<String,String>> page = new ArrayList<>();
        Map<String,String> m1 = new HashMap<>();
        m1.put("id", "Page_1");
        m1.put("src", "http://211.87.232.197:8081/sdudoc/img/get_by_id?id=2");
        m1.put("width", 1030+"");
        m1.put("height", 1832+"");
        page.add(m1);
        Map<String,String> m2 = new HashMap<>();
//        m2.put("id", "Page_2");
//        m2.put("src", "http://211.87.232.197:8081/sdudoc/img/get_by_id?id=2");
//        m2.put("width", 1030+"");
//        m2.put("height", 1832+"");
        page.add(m2);
        System.out.println(page);
        dmsArticle.set_id("111");
        dmsArticle.setPage(page);
        System.out.println(dmsArticle);
        solrClient.addBean("dms_article",dmsArticle);
        solrClient.commit("dms_article");
        System.out.println("添加成功"+dmsArticle);
    }

    @Test
    public void insert_sdudoc() throws SolrServerException, IOException {
        JSONObject json = JSONObject.parseObject("{\"Header\":{\"title\":\"\",\"author\":\"\",\"book\":\"\",\"dynasty\":\"\"},\"Document\":[\"后\"],\"Page\":[{\"id\":\"Page_1\",\"src\":\"http://211.87.232.197:8081/sdudoc/img/get_by_id?id=2\",\"width\":1030,\"height\":1832}],\"Dot2D\":[],\"Polygon2D\":[],\"Character\":[{\"id\":\"Character_1\",\"page\":\"Page_1\",\"father\":\"Word_1\",\"string\":\"后\",\"points\":[[\"982.13\",\"307.94\"],[\"815.11\",\"318.38\"],[\"820.33\",\"180.07\"],[\"979.52\",\"180.07\"]]}],\"Word\":[{\"id\":\"Word_1\",\"pages\":[\"Page_1\"],\"children\":[\"Character_1\"],\"father\":\"\",\"string\":[\"后\"],\"points\":[\"Page_1|982.13:307.94;815.11:318.38;820.33:180.07;979.52:180.07\"]}]}");
        solrServiceImpl.insertSdudoc(json);
    }

    @Test
    public void getSVG() throws SolrServerException, IOException {
//        solrService.getSVG("60973c77a17e0d7165506cb3","李克","515");
        //solrService.getSVG("609de5f98b052b0d5ab049e6","斗罗","515","916");
        //solrServiceImpl.queryOne("dms_word", "article", "609de5f98b052b0d5ab049e6");

        //System.out.println(solrController.query("dms_word","","","",0,5));
        solrService.getSVG("60a3bc782c8a3f0862e43f8f","后","500","700");
    }

    @Test
    public void queryCharacter() throws SolrServerException, IOException {
        JSONArray word_array = solrServiceImpl.queryWord("dms_word","word","唐 门","609d57b71a788c61fde33244");
        if(word_array.isEmpty())
            System.out.println("空");
        else{
            System.out.println(word_array);
            List<SolrDocument> word_list = new ArrayList<>();
            for(Object o : word_array){
                word_list.add((SolrDocument) o);
            }
            for(SolrDocument s:word_list){
                System.out.println(s.get("position"));
            }
//            for(SolrDocument s : word_list){
//                String page = (String)((ArrayList)s.get("page")).get(0);
//                ArrayList<String> position = (ArrayList)s.get("position");
//                for(PageInfo page_info : page_list){
//                    if(page_info.getId().equals(page)){
//                        page_info.addPolygon(position);
//                    }
//                }
//            }
        }


    }

}
