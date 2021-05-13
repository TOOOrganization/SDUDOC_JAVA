package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsArticleRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.service.serviceImpl.SolrServiceImpl;
import cn.edu.sdu.sdudoc.util.DataOutput;
import cn.edu.sdu.sdudoc.util.PageInfo;
import cn.edu.sdu.sdudoc.util.SolrInput;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import java.util.List;

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
    SolrService solrService;

    @Autowired
    SolrServiceImpl solrServiceImpl;

    @Test
    public void getSVG() throws SolrServerException, IOException {
//        solrService.getSVG("60973c77a17e0d7165506cb3","李克","515");
        solrService.getSVG("609d0b68e1c36177de7a2e57","天府国","515","916");
    }

    @Test
    public void queryCharacter() throws SolrServerException, IOException {
        JSONArray word_array = solrServiceImpl.queryWord("dms_word","word","天府之国","609d0b68e1c36177de7a2e57");
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
