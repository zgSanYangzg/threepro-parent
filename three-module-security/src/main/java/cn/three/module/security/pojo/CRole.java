package cn.three.module.security.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Entity
@Table(name="DTCROLE")
public class CRole {
    @Id
    @GeneratedValue(generator = "pg")
    @GenericGenerator(name = "pg", strategy = "guid")
    @Column(name = "ROLEKEY",length = 50,nullable = false)
    private String roleKey;
    @Column(name = "ROLEID",length = 50,nullable = false)
    private String roleID;
    @Column(name = "COMPANYID",length = 50,nullable = false)
    private String companyID;
    @Column(name = "COMPANYNAME",length = 250)
    private String companyName;//公司名称
    @Column(name = "ORGANIZATIONNAME",length = 250)
    private String organizationName;//部门名称ID
    @Column(name = "ORGANIZATIONNAMEDESC",length = 250)
    private String organizationNameDesc;//部门名称
    @Column(name = "OPOSTNAME",length = 250)
    private String opostName;//岗位名称
    @Column(name = "ROLENAME",length = 250,nullable = false)
    private String roleName;//职务名称（权限名称）
    @Column(name = "ROLEDESC",length = 250)
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
}
