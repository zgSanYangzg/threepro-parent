package cn.three.module.account.pojo.model;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public class CRoleModel {
    private String roleKey;
    private String roleID;
    private String companyID;
    private String companyName;//公司名称
    private String organizationName;//部门名称ID
    private String organizationNameDesc;//部门名称
    private String opostName;//岗位名称
    private String roleName;//职务名称（权限名称）
    private String roleDesc;


    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationNameDesc() {
        return organizationNameDesc;
    }

    public void setOrganizationNameDesc(String organizationNameDesc) {
        this.organizationNameDesc = organizationNameDesc;
    }

    public String getOpostName() {
        return opostName;
    }

    public void setOpostName(String opostName) {
        this.opostName = opostName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CRoleModel{");
        sb.append("roleKey='").append(roleKey).append('\'');
        sb.append(", roleID='").append(roleID).append('\'');
        sb.append(", companyID='").append(companyID).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", organizationName='").append(organizationName).append('\'');
        sb.append(", organizationNameDesc='").append(organizationNameDesc).append('\'');
        sb.append(", opostName='").append(opostName).append('\'');
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", roleDesc='").append(roleDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
