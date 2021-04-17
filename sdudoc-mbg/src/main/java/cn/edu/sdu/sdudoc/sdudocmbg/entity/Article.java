package cn.edu.sdu.sdudoc.sdudocmbg.entity;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "article")
public class Article implements Serializable {

    @Id
    @ApiModelProperty(value = "文章id")
    private String id;

    @ApiModelProperty(value = "文章作者")
    private String articleAuthor;

    @ApiModelProperty(value = "书名")
    private String bookname;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "图片链接")
    private String imgUrl;

    @ApiModelProperty(value = "页码")
    private long page;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "xml文档")
    private String xml;

    @ApiModelProperty(value = "注解")
    private String annotation;

    @ApiModelProperty(value = "详细注解")
    private JSONObject jsonObject;

    // getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
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

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

}
