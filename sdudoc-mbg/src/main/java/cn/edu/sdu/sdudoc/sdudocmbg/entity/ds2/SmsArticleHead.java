package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "ds2SmsArticleHead")
@Table(name = "sms_article_head")
public class SmsArticleHead implements Serializable {
    @Id
    @ApiModelProperty(value = "文章头id")
    private String aid;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章作者")
    private String articleauthor;

    @ApiModelProperty(value = "书名")
    private String bookname;

    @ApiModelProperty(value = "朝代")
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
