package cn.three.module.account.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/2/2.
 */
@Entity
@Table(name = "DT_GROUP_ROLE")
public class GroupRole {
    @Id
    @GeneratedValue(generator = "gd")
    @GenericGenerator(name = "gd",strategy = "guid")
    @Column(name = "GROUPROLEKEY",length = 50,nullable = false)
    private String groupRoleKey;
    @Column(name = "GROUPROLEID",length = 50,nullable = false)
    private String groupRoleId;
    @Column(name = "COMPANYID",length = 50,nullable = false)
    private String companyId;
    @Column(name = "ROLEID",length = 50,nullable = false)
    private String roleId;
    @Column(name = "GROUPINFOID",length = 50,nullable = false)
    private String groupInfoId;

    public String getGroupRoleKey() {
        return groupRoleKey;
    }

    public void setGroupRoleKey(String groupRoleKey) {
        this.groupRoleKey = groupRoleKey;
    }

    public String getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(String groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getGroupInfoId() {
        return groupInfoId;
    }

    public void setGroupInfoId(String groupInfoId) {
        this.groupInfoId = groupInfoId;
    }
}
