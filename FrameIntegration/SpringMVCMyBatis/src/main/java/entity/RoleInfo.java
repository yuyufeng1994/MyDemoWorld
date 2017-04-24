package entity;

public class RoleInfo {
    private Integer roleId;

    private String roleName;

    public RoleInfo(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}