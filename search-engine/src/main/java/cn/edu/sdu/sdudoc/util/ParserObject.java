package cn.edu.sdu.sdudoc.util;

import cn.edu.sdu.sdudoc.SearchEngineApplication;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

public class ParserObject {

    MongoInput mongoInput = new MongoInput();

    private final HashMap object;

    public ParserObject(HashMap object) {
        this.object = object;
    }

    public HashMap getHeadInfo(){
        return (HashMap) object.get("document_info");
    }

    public List<Object> getCharacter(){
        return (List<Object>) object.get("Character");
    }

    public List<Object> getWord(){
        return (List<Object>) object.get("Word");
    }

    public List<Object> getSentence(){
        return (List<Object>) object.get("Sentence");
    }

    public List<Object> getParagraph(){
        return (List<Object>) object.get("Paragraph");
    }

    public void saveArticle(){
        HashMap document_info = (HashMap) object.get("document_info");
        DmsArticle dmsArticle = new DmsArticle();
        dmsArticle.setBookname((String) document_info.get("name"));
        dmsArticle.setArticleAuthor((String) document_info.get("Author"));
        dmsArticle.setDynasty((String) document_info.get("dynasty"));
        mongoInput.saveArticle(dmsArticle);
    }
}
