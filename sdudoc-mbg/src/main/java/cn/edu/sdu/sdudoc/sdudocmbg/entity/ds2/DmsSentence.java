package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2;

import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("dms_sentence")
public class DmsSentence implements Serializable {

    @Id
    @Field("_id")
    @ApiModelProperty(value = "_id")
    private String _id;


    @Field("id")
    @ApiModelProperty(value = "id")
    private String id;

    @Field("sentence")
    @ApiModelProperty(value = "sentence")
    private String sentence;

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

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String[][] getArticles() {
        return articles;
    }

    public void setArticles(String[][] articles) {
        this.articles = articles;
    }
}
