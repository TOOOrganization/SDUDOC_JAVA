package cn.edu.sdu.component;

public class JpaRightForRoleVo {
    Integer rid;

    String role_name;

    Integer right_id;

    String right_name;

    String role_description;

    String right_description;

    Boolean right_type;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
    }

    public String getRight_name() {
        return right_name;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public String getRight_description() {
        return right_description;
    }

    public void setRight_description(String right_description) {
        this.right_description = right_description;
    }

    public Boolean getRight_type() {
        return right_type;
    }

    public void setRight_type(Boolean right_type) {
        this.right_type = right_type;
    }

    @Override
    public String toString() {
        return "JpaRightForRoleVo{" +
                "rid=" + rid +
                ", role_name='" + role_name + '\'' +
                ", right_id=" + right_id +
                ", right_name='" + right_name + '\'' +
                ", role_description='" + role_description + '\'' +
                ", right_description='" + right_description + '\'' +
                ", right_type=" + right_type +
                '}';
    }
}
