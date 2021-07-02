package cn.edu.sdu.search.util;

import cn.edu.sdu.entity.ds1.DmsArticle;
import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.entity.ds1.SmsArticleHead;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParserObject {

    @Autowired
    MongoInput mongoInput;

    final public String HEADER = "Header";

    final public String CHARACTER = "Character";

    final public String WORD = "Word";

    final public String SENTENCE = "Sentence";

    final public String PARAGRAPH = "Paragraph";

    final public String ARTICLE = "Article";

    final public String BOOK = "Book";

    final public String PAGE = "Page";

    final public String DOCUMENT = "Document";

    final static class Header {
        final static public String TITLE = "title";

        final static public String AUTHOR = "author";

        final static public String BOOK = "book";

        final static public String DYNASTY = "dynasty";
    }

    final static class Character {
        final static public String STRING = "string";

        final static public String POINTS = "points";
    }

    final static class Word {
        final static public String STRING = "string";

        final static public String POINTS = "points";

        final static public String PAGES = "pages";
    }

    public Map<String, Object> getHeader(Map<String, Object> map){
        return getMap(map, HEADER);
    }

    public List<Map<String, Object>> getCharacter(Map<String, Object> map){
        return getListMap(map, CHARACTER);
    }

    public List<Map<String, Object>> getWord(Map<String, Object> map){
        return getListMap(map, WORD);
    }

    public List<Map<String, Object>> getSentence(Map<String, Object> map){
        return getListMap(map, SENTENCE);
    }

    public List<Map<String, Object>> getParagraph(Map<String, Object> map){
        return getListMap(map, PARAGRAPH);
    }

    public List<Map<String, Object>> getArticle(Map<String, Object> map){
        return getListMap(map, ARTICLE);
    }

    public List<Map<String, Object>> getBook(Map<String, Object> map){
        return getListMap(map, BOOK);
    }

    public DmsArticle fileChecksumExist(DmsArticle dmsArticle) {
        Optional<DmsArticle> one = mongoInput.findOneArticle(dmsArticle);
        return one.orElse(null);
    }

    public DmsArticle saveArticle(Map<String, Object> map){
        Map<String, Object> header = getHeader(map);

        DmsArticle dmsArticle = new DmsArticle();
        dmsArticle.setTitle(getString(header, Header.TITLE));
        dmsArticle.setArticleAuthor(getString(header, Header.AUTHOR));
        dmsArticle.setBookname(getString(header, Header.BOOK));
        dmsArticle.setDynasty(getString(header, Header.DYNASTY));
        dmsArticle.setPage(createPage(map));

        List<String> docList = getList(map, DOCUMENT);
        StringBuilder document = new StringBuilder();
        for (String doc : docList){
            document.append(doc);
        }
        dmsArticle.setContent(String.valueOf(document));
        DmsArticle result;
        //如果文章已存在，则返回null
        if(this.fileChecksumExist(dmsArticle) == null){
            result = mongoInput.saveArticle(dmsArticle);
        }else{
            result = null ;
        }
        System.out.println(result);
        return result;
    }

    public SmsArticleHead saveArticleHead(Map<String, Object> map, String article_id){
        Map<String, Object> header = getHeader(map);
        SmsArticleHead smsArticleHead = new SmsArticleHead();

        smsArticleHead.setAid(article_id);
        smsArticleHead.setTitle(getString(header, Header.TITLE));
        smsArticleHead.setArticleauthor(getString(header, Header.AUTHOR));
        smsArticleHead.setBookname(getString(header, Header.BOOK));
        smsArticleHead.setDynasty(getString(header, Header.DYNASTY));

        SmsArticleHead result = mongoInput.saveArticleHead(smsArticleHead);
        System.out.println(result);
        return result;
    }

    public DmsCharacter saveCharacter(Map<String, Object> map, DmsArticle article){
        DmsCharacter dmsCharacter = new DmsCharacter();

        dmsCharacter.setCharacter(getString(map, Character.STRING));
        dmsCharacter.setArticle(article.get_id());
        dmsCharacter.setPosition(getList(map, Character.POINTS));
        dmsCharacter.setPage((String)map.get("page"));

        DmsCharacter result = mongoInput.saveCharacter(dmsCharacter);
        System.out.println(result);
        return result;
    }

    public DmsWord saveWord(Map<String, Object> map, DmsArticle article){
        DmsWord dmsWord = new DmsWord();

        List<String> char_list = getList(map, Word.STRING);
        StringBuilder word = new StringBuilder();
        for(String s : char_list){
            word.append(s);
        }
        System.out.println(word);

        dmsWord.setWord(String.valueOf(word));
        dmsWord.setArticle(article.get_id());
        dmsWord.setPage(getList(map, Word.PAGES));
        dmsWord.setPosition(getList(map, Word.POINTS));

        DmsWord result = mongoInput.saveWord(dmsWord);
        System.out.println(result);
        return dmsWord;
    }

    public String getString(Map<String, Object> map, String field) {
        return String.valueOf(map.get(field));
    }

    public Map<String, Object> getMap(Map<String, Object> map, String field) {
        return JSONObject.parseObject(JSON.toJSONString(map.get(field)));
    }

    public List<String> getList(Map<String, Object> map, String field) {
        return JSONObject.parseArray(JSON.toJSONString(map.get(field)), String.class);
    }

    public List<Map<String, Object>> getListMap(Map<String, Object> map, String field) {
        List<Object> temp = JSONObject.parseArray(JSON.toJSONString(map.get(field)));
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object o : temp) {
            result.add(JSONObject.parseObject(JSON.toJSONString(o)));
        }

        return result;
    }

    public List<Map<String, String>> createPage(Map<String, Object> map) {
        List<Map<String, String>> result = new ArrayList<>();
        List<Map<String, Object>> listMap = getListMap(map, PAGE);

        for (Map<String, Object> stringObjectMap : listMap) {
            Map<String, String> tempMap = stringObjectMap.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));

            result.add(tempMap);
        }
        result.add(new HashMap<>());

        return result;
    }
}
