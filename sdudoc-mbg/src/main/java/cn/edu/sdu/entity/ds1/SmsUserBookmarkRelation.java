package cn.edu.sdu.entity.ds1;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "ds1SmsUserBookmarkRelation")
@Table(name = "sms_user_bookmark_relation")
public class SmsUserBookmarkRelation implements Serializable {
    @Id
    @ApiModelProperty(value = "mid")
    private String mid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "文章id")
    private String aid;

    @ApiModelProperty(value = "插入时间")
    private String add_time;

    public SmsUserBookmarkRelation() {

    }

    public SmsUserBookmarkRelation(String username, String aid) {
        this.username = username;
        this.aid = aid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    @Override
    public String toString() {
        return "SmsUserBookmarkRelation{" +
                "username='" + username + '\'' +
                ", aid='" + aid + '\'' +
                ", add_time=" + add_time +
                '}';
    }
}
