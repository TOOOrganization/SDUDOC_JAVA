package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

@Entity(name = "ds2PmsUserScoreRelation")
@Table(name = "pms_user_point_relation")
public class PmsUserPointRelation implements Serializable {

    @Id
    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "积分")
    private BigInteger score;


    public PmsUserPointRelation() {

    }

    public PmsUserPointRelation(Integer uid, BigInteger score) {
        this.uid = uid;
        this.score = score;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigInteger getScore() {
        return score;
    }

    public void setScore(BigInteger score) {
        this.score = score;
    }

}

