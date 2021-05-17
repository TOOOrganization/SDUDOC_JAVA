package cn.edu.sdu.sdudoc.sdudocmbg.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@Document("dms_article")
public class DmsArticle implements Serializable {

    @Id
    @Field("_id")
    private String _id;

    @Field("articleAuthor")
    @ApiModelProperty(value = "文章作者")
    private String articleAuthor;

    @Field("bookname")
    @ApiModelProperty(value = "书名")
    private String bookname;

    @Field("content")
    @ApiModelProperty(value = "内容")
    private String content;

    @Field("imgurl")
    @ApiModelProperty(value = "图片链接")
    private String imgUrl;

    @Field("page")
    @ApiModelProperty(value = "页码")
    private ArrayList<HashMap<String,String>> page;

    @Field("title")
    @ApiModelProperty(value = "标题")
    private String title;

    @Field("XML")
    @ApiModelProperty(value = "xml文档")
    private String xml;

    @Field("annotation")
    @ApiModelProperty(value = "文章注解")
    private String annotation;

    @Field("dynasty")
    @ApiModelProperty(value = "朝代")
    private String dynasty;

    @Field("notes")
    @ApiModelProperty(value = "详细注解")
    private JSONArray notes;

// getter and setter


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ArrayList<HashMap<String,String>> getPage() {
        return page;
    }

    public void setPage(ArrayList<HashMap<String,String>> page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public JSONArray getNotes() {
        return notes;
    }

    public void setNotes(JSONArray notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Article{" +
                "_id='" + _id + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", bookname='" + bookname + '\'' +
                ", content='" + content + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", page=" + page +
                ", title='" + title + '\'' +
                ", xml='" + xml + '\'' +
                ", annotation='" + annotation + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", notes=" + notes +
                '}';
    }
}
