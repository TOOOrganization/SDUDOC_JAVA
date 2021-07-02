package cn.edu.sdu.manager.component;

public class JpaRoleForUserVo {
    Integer uid;

    String username;

    Integer rid;

    String role_name;

    String role_description;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    @Override
    public String toString() {
        return "JpaRoleForUserVo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", rid=" + rid +
                ", role_name='" + role_name + '\'' +
                ", role_description='" + role_description + '\'' +
                '}';
    }
}
