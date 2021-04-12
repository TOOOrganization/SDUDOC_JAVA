package cn.edu.sdu.sdudoc.sdudocdao.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsRight implements Serializable {
    @ApiModelProperty(value = "权限id")
    private Integer rightId;

    @ApiModelProperty(value = "父权限id")
    private Integer parentTightId;

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

    public Integer getParentTightId() {
        return parentTightId;
    }

    public void setParentTightId(Integer parentTightId) {
        this.parentTightId = parentTightId;
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
        sb.append(", parentTightId=").append(parentTightId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}