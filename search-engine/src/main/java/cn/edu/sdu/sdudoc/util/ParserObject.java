package cn.edu.sdu.sdudoc.util;

import cn.edu.sdu.sdudoc.SearchEngineApplication;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.Img;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.SmsArticleHead;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ParserObject {

    @Autowired
    MongoInput mongoInput;


    public HashMap getHeader(HashMap object){
        return (HashMap) object.get("Header");
    }

    public List<HashMap> getCharacter(HashMap object){
        return (List<HashMap>) object.get("Character");
    }

    public List<HashMap> getWord(HashMap object){
        return (List<HashMap>) object.get("Word");
    }

    public List<HashMap> getSentence(HashMap object){
        return (List<HashMap>) object.get("Sentence");
    }

    public List<HashMap> getParagraph(HashMap object){
        return (List<HashMap>) object.get("Paragraph");
    }

    public List<HashMap> getArticle(HashMap object){
        return (List<HashMap>) object.get("Article");
    }

    public List<HashMap> getBook(HashMap object){
        return (List<HashMap>) object.get("Book");
    }

    public DmsArticle fileChecksumExist(DmsArticle dmsArticle) {
        Optional<DmsArticle> one = mongoInput.findOneArticle(dmsArticle);
        return one.orElse(null);
    }

    public DmsArticle saveArticle(HashMap object){
        HashMap header = (HashMap) object.get("Header");
        DmsArticle dmsArticle = new DmsArticle();
        dmsArticle.setTitle((String) header.get("title"));
        dmsArticle.setArticleAuthor((String) header.get("author"));
        dmsArticle.setBookname((String) header.get("book"));
        dmsArticle.setDynasty((String) header.get("dynasty"));
        dmsArticle.setPage((ArrayList<HashMap<String,String>>) object.get("Page"));
        ArrayList<String> doclist = (ArrayList) object.get("Document");
        StringBuilder document = new StringBuilder();
        for (String doc : doclist){
            document.append(doc);
        }
        dmsArticle.setContent(String.valueOf(document));
        DmsArticle result;
        if(this.fileChecksumExist(dmsArticle) == null){
            result = mongoInput.saveArticle(dmsArticle);
        }else{
            result = null ;
        }
        System.out.println(result);
        return result;
    }

    public SmsArticleHead saveArticleHead(HashMap object, String article_id){
        HashMap header = (HashMap) object.get("Header");
        SmsArticleHead smsArticleHead = new SmsArticleHead();
        smsArticleHead.setAid(article_id);
        smsArticleHead.setTitle((String) header.get("title"));
        smsArticleHead.setArticleauthor((String) header.get("author"));
        smsArticleHead.setBookname((String) header.get("book"));
        smsArticleHead.setDynasty((String) object.get("dynasty"));
        SmsArticleHead result = mongoInput.saveArticleHead(smsArticleHead);
        System.out.println(result);
        return result;
    }

    public DmsCharacter saveCharacter(HashMap object,DmsArticle article){
        DmsCharacter dmsCharacter = new DmsCharacter();
        dmsCharacter.setCharacter((String) object.get("string"));
        dmsCharacter.setArticles(article.get_id());
        dmsCharacter.setPosition((ArrayList) object.get("points"));
//        ArrayList<HashMap<String,String>> pagelist = article.getPage();
//        HashMap<String, String> pagemap = new HashMap<>();
//        for(HashMap<String,String> m :pagelist){
//            pagemap.put(m.get("id"),m.get("src"));
//        }
        dmsCharacter.setPage((String)object.get("page"));
        DmsCharacter result = mongoInput.saveCharacter(dmsCharacter);
        System.out.println(dmsCharacter);
        System.out.println(result);
        return result;
    }
}
