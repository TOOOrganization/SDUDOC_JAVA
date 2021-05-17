package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document("dms_character")
public class DmsCharacter implements Serializable {

    @Id
    @Field("_id")
    @ApiModelProperty(value = "_id")
    private String _id;

    @Field("character")
    @ApiModelProperty(value = "character")
    private String character;

    @Field("pronunciation")
    @ApiModelProperty(value = "pronunciation")
    private String pronunciation;

    @Field("meaning")
    @ApiModelProperty(value = "meaning")
    private String meaning;

    @Field("notes")
    @ApiModelProperty(value = "notes")
    private String notes;

    @Field("diff_form")
    @ApiModelProperty(value = "diff_form")
    private String[] diff_form;

    @Field("diff_pron")
    @ApiModelProperty(value = "diff_pron")
    private String[] diff_pron;

    @Field("article")
    @ApiModelProperty(value = "article")
    private String article;

    @Field("page")
    @ApiModelProperty(value = "page")
    private String page;

    @Field("position")
    @ApiModelProperty(value = "position")
    private List position;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String[] getDiff_form() {
        return diff_form;
    }

    public void setDiff_form(String[] diff_form) {
        this.diff_form = diff_form;
    }

    public String[] getDiff_pron() {
        return diff_pron;
    }

    public void setDiff_pron(String[] diff_pron) {
        this.diff_pron = diff_pron;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String articles) {
        this.article = articles;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List getPosition() {
        return position;
    }

    public void setPosition(List position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "DmsCharacter{" +
                "_id='" + _id + '\'' +
                ", character='" + character + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", meaning='" + meaning + '\'' +
                ", notes='" + notes + '\'' +
                ", diff_form=" + Arrays.toString(diff_form) +
                ", diff_pron=" + Arrays.toString(diff_pron) +
                ", article='" + article + '\'' +
                ", position=" + position +
                '}';
    }
}

