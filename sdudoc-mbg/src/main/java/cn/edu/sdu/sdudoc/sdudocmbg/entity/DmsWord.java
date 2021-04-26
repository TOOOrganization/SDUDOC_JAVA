package cn.edu.sdu.sdudoc.sdudocmbg.entity;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("dms_word")
public class DmsWord implements Serializable {

    @Id
    @Field("_id")
    @ApiModelProperty(value = "_id")
    private String _id;

    @Field("id")
    @ApiModelProperty(value = "id")
    private String id;

    @Field("word")
    @ApiModelProperty(value = "word")
    private String word;

    @Field("articles")
    @ApiModelProperty(value = "articles")
    private String[][] articles;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[][] getArticles() {
        return articles;
    }

    public void setArticles(String[][] articles) {
        this.articles = articles;
    }
}
