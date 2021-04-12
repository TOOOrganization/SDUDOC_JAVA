package cn.edu.sdu.sdudoc.sdudocdao.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SmsArticleHead implements Serializable {
    private String aid;

    private String title;

    private String articleauthor;

    private String bookname;

    private String dynasty;

    private static final long serialVersionUID = 1L;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid == null ? null : aid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getArticleauthor() {
        return articleauthor;
    }

    public void setArticleauthor(String articleauthor) {
        this.articleauthor = articleauthor == null ? null : articleauthor.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", title=").append(title);
        sb.append(", articleauthor=").append(articleauthor);
        sb.append(", bookname=").append(bookname);
        sb.append(", dynasty=").append(dynasty);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}