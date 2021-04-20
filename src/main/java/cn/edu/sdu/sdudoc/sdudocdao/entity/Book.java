package cn.edu.sdu.sdudoc.sdudocdao.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    @ApiModelProperty(value = "添加时间")
    private Date addtime;

    @ApiModelProperty(value = "书籍作者")
    private String bookauthor;

    @ApiModelProperty(value = "朝代")
    private String dynasty;

    @ApiModelProperty(value = "书籍名称")
    private String bookname;

    @ApiModelProperty(value = "成书日期")
    private Date pulishedtime;

    @ApiModelProperty(value = "文章数目")
    private String totalarticle;

    @ApiModelProperty(value = "创建者id")
    private String uid;

    private static final long serialVersionUID = 1L;

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Date getPulishedtime() {
        return pulishedtime;
    }

    public void setPulishedtime(Date pulishedtime) {
        this.pulishedtime = pulishedtime;
    }

    public String getTotalarticle() {
        return totalarticle;
    }

    public void setTotalarticle(String totalarticle) {
        this.totalarticle = totalarticle == null ? null : totalarticle.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addtime=").append(addtime);
        sb.append(", bookauthor=").append(bookauthor);
        sb.append(", dynasty=").append(dynasty);
        sb.append(", bookname=").append(bookname);
        sb.append(", pulishedtime=").append(pulishedtime);
        sb.append(", totalarticle=").append(totalarticle);
        sb.append(", uid=").append(uid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}