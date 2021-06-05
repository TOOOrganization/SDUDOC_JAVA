package cn.edu.sdu.entity.ds2;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ds2SmsSearchHistory")
@Table(name = "sms_search_history")
public class SmsSearchHistory implements Serializable {
    @Id
    @ApiModelProperty(value = "搜索历史id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "搜索历史")
    private String word;

    @ApiModelProperty(value = "添加时间")
    private String addTime;

    @ApiModelProperty(value =
            "1-模糊搜索作者\n" +
            "2-模糊搜索标题\n" +
            "3-模糊搜索原文\n" +
            "4-精准搜索作者\n" +
            "5-精准搜索标题\n" +
            "6-精准搜索原文")
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hid=").append(hid);
        sb.append(", username=").append(username);
        sb.append(", word=").append(word);
        sb.append(", addTime=").append(addTime);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
