package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
public class PmsUserScoreRelation implements Serializable {

    @Id
    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "积分")
    private BigInteger score;


    public PmsUserScoreRelation() {

    }

    public PmsUserScoreRelation(Integer uid, BigInteger score) {
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

