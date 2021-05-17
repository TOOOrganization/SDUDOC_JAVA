package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UmsRoleRightRelation implements Serializable {
    @Id
    @ApiModelProperty(value = "映射id")
    private Integer rrid;

    @ApiModelProperty(value = "角色id")
    private Integer rid;

    @ApiModelProperty(value = "权限id")
    private Integer rightId;

    @ApiModelProperty(value = "权限类型 0可访问 1可授权")
    private Boolean rightType;

    private static final long serialVersionUID = 1L;

    public Integer getRrid() {
        return rrid;
    }

    public void setRrid(Integer rrid) {
        this.rrid = rrid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Boolean getRightType() {
        return rightType;
    }

    public void setRightType(Boolean rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rrid=").append(rrid);
        sb.append(", rid=").append(rid);
        sb.append(", rightId=").append(rightId);
        sb.append(", rightType=").append(rightType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
