package cn.edu.sdu.sdudoc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import cn.edu.sdu.sdudoc.common.JsonParser;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsWord;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.DmsCharacterService;
import cn.edu.sdu.sdudoc.util.ParserObject;
import cn.edu.sdu.sdudoc.util.SolrInput;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class JsonParserTest {

    @Autowired
    ParserObject m;

    @Autowired
    SolrInput solrInput;

    @Test
    public void parseComplexObject() throws IOException, URISyntaxException, SolrServerException {
        URL url = new ClassPathResource("/static/Untitled(1).sdudoc").getURL();
        String json = readFile(url.toString().substring(6));
//        "E:/DevelopWork/IDEAProjects/sdudoc-search/search-engine/src/main/resources/static/example.json"
        System.out.println("origin json content:{"+json+"}");
        JsonParser parser = new JsonParser(json);
        HashMap object = (HashMap) parser.parse();
        //在mongodb插入文章，获取文章id
        DmsArticle article = m.saveArticle(object);
        if(article == null){
            return;
        }
        //在mysql插入文章头信息
        m.saveArticleHead(object,article.get_id());
        //在mongodb插入字
        List<HashMap> characters = m.getCharacter(object);
//        DmsCharacter[] characterss = new DmsCharacter[characters.size()];
        Collection<DmsCharacter> characterss = new ArrayList<DmsCharacter>();
        int count = 0;
        for(HashMap h : characters){
            characterss.add(m.saveCharacter(h,article));
        }
        //在mongodb插入词
        List<HashMap> words = m.getWord(object);
//        DmsWord[] wordss = new DmsWord[words.size()];
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
        System.out.println("parsed object:{"+object+"}");
    }

    @Autowired
    private DmsArticleService dmsArticleService;

    @Autowired
    private DmsCharacterService dmsCharacterService;

    @Test
    public void getData(){
        System.out.println(dmsArticleService);
        String s = JSONObject.toJSONString(dmsArticleService.findAll());
        System.out.println(s);
    }

//    @Test
//    public void parseEmptyObject() throws IOException, URISyntaxException {
//        String json = readFile("/empty.json");
//        System.out.println("origin json content:{"+json+"}");
//        JsonParser parser = new JsonParser(json);
//        Object object = parser.parse();
//        System.out.println("parsed object:{"+object+"}");
//    }
//
//    @Test
//    public void parseArray() throws IOException, URISyntaxException {
//        String json = readFile("/array.json");
//        System.out.println("origin json content:{"+json+"}");
//        JsonParser parser = new JsonParser(json);
//        Object object = parser.parse();
//        System.out.println("parsed object:{"+object+"}");
//    }

    public static String readFile(String Path){
        System.out.println(Path);
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

}
