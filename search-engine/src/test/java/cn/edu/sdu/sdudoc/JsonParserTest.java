package cn.edu.sdu.sdudoc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.sdu.sdudoc.common.JsonParser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsArticleRepository;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsCharacterRepository;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.DmsCharacterService;
import cn.edu.sdu.sdudoc.util.MongoInput;
import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchEngineApplication.class)
public class JsonParserTest {

    @Test
    public void parseComplexObject() throws IOException, URISyntaxException{
        URL url = new ClassPathResource("/static/Untitled.sdudoc").getURL();
        String json = readFile(url.toString().substring(6));
//        "E:/DevelopWork/IDEAProjects/sdudoc-search/search-engine/src/main/resources/static/example.json"
        System.out.println("origin json content:{"+json+"}");
        JsonParser parser = new JsonParser(json);
        HashMap object = (HashMap) parser.parse();
        MongoInput m = new MongoInput(object);
        //System.out.println(object.get("Word"));
        HashMap document_info = (HashMap) object.get("document_info");
        List<Object> charcater = (List<Object>) object.get("Character");
        List<Object> word = (List<Object>) object.get("Word");
        List<Object> sentence = (List<Object>) object.get("Sentence");
        List<Object> paragraph = (List<Object>) object.get("Paragraph");
        System.out.println(m.getHeadInfo());
        System.out.println(m.getCharacter());
        System.out.println(m.getWord());
        System.out.println(m.getSentence());
        System.out.println(m.getParagraph());
        System.out.println("parsed object:{"+object+"}");
        m.saveArticle();
    }

    @Autowired
    private DmsArticleService dmsArticleService;

    @Autowired
    private DmsCharacterService dmsCharacterService;

    @Test
    public void getData(){
        System.out.println(dmsCharacterService);
        String s = JSONObject.toJSONString(dmsCharacterService.findAll());
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
