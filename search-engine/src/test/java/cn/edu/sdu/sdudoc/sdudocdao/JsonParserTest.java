package cn.edu.sdu.sdudoc.sdudocdao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import cn.edu.sdu.sdudoc.sdudocdao.common.JsonParser;
import org.springframework.core.io.ClassPathResource;
import org.junit.Test;

public class JsonParserTest {

    @Test
    public void parseComplexObject() throws IOException, URISyntaxException{
        URL url = new ClassPathResource("/static/example.json").getURL();
        String json = readFile(url.toString().substring(6));
//        "E:/DevelopWork/IDEAProjects/sdudoc-search/search-engine/src/main/resources/static/example.json"
        System.out.println("origin json content:{"+json+"}");
        JsonParser parser = new JsonParser(json);
        Object object = parser.parse();
        System.out.println("parsed object:{"+object+"}");
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
