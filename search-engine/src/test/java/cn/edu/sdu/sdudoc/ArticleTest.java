package cn.edu.sdu.sdudoc;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsArticleRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.SolrService;
import cn.edu.sdu.sdudoc.util.DataOutput;
import cn.edu.sdu.sdudoc.util.SolrInput;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

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

    @Test
    public void getSVG() throws SolrServerException, IOException {
        solrService.getSVG("60973c77a17e0d7165506cb3","李克","515");
    }

}
