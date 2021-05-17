package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@Document("dms_word")
public class DmsWord implements Serializable {

    @Id
    @Field("_id")
    @ApiModelProperty(value = "_id")
    private String _id;

    @Field("word")
    @ApiModelProperty(value = "word")
    private String word;

    @Field("article")
    @ApiModelProperty(value = "article")
    private String article;

    @Field("page")
    @ApiModelProperty(value = "page")
    private ArrayList page;

    @Field("position")
    @ApiModelProperty(value = "position")
    private ArrayList position;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public ArrayList getPage() {
        return page;
    }

    public void setPage(ArrayList page) {
        this.page = page;
    }

    public ArrayList getPosition() {
        return position;
    }

    public void setPosition(ArrayList position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "DmsWord{" +
                "_id='" + _id + '\'' +
                ", word='" + word + '\'' +
                ", article='" + article + '\'' +
                ", page=" + page +
                ", position=" + position +
                '}';
    }
}
