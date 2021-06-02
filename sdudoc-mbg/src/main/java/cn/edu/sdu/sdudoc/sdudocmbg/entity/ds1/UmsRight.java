package cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "ds1UmsRight")
@Table(name = "ums_right")
public class UmsRight implements Serializable {
    @Id
    @ApiModelProperty(value = "权限id")
    private Integer rightId;

    @ApiModelProperty(value = "父权限id")
    private Integer parentRightId;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限描述")
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getParentRightId() {
        return parentRightId;
    }

    public void setParentRightId(Integer parentTightId) {
        this.parentRightId = parentTightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rightId=").append(rightId);
        sb.append(", parentTightId=").append(parentRightId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
