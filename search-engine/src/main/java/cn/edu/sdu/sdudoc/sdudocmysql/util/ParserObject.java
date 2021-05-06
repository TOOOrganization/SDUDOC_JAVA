package cn.edu.sdu.sdudoc.sdudocmysql.util;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ParserObject {

    @Autowired
    MongoInput mongoInput;


    public HashMap getHeadInfo(HashMap object){
        return (HashMap) object.get("document_info");
    }

    public List<Object> getCharacter(HashMap object){
        return (List<Object>) object.get("Character");
    }

    public List<Object> getWord(HashMap object){
        return (List<Object>) object.get("Word");
    }

    public List<Object> getSentence(HashMap object){
        return (List<Object>) object.get("Sentence");
    }

    public List<Object> getParagraph(HashMap object){
        return (List<Object>) object.get("Paragraph");
    }

    public void saveArticle(HashMap object){
        HashMap document_info = (HashMap) object.get("document_info");
        DmsArticle dmsArticle = new DmsArticle();
        dmsArticle.setBookname((String) document_info.get("name"));
        dmsArticle.setArticleAuthor((String) document_info.get("Author"));
        dmsArticle.setDynasty((String) document_info.get("dynasty"));
        mongoInput.saveArticle(dmsArticle);
    }
}
