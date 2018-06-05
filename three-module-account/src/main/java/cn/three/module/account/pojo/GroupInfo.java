package cn.three.module.account.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/2/2.
 */
@Entity
@Table(name = "DT_GROUPINFO")
public class GroupInfo {

    @Id
    @GeneratedValue(generator = "gd")
    @GenericGenerator(name = "gd",strategy = "guid")
    @Column(name="GROUPINFOKEY",length = 50,nullable = false)
    private String groupInfoKey;
    @Column(name="GROUPINFOID",length = 50,nullable = false)
    private String groupInfoId;
    @Column(name="GROUPNAME",length = 150,nullable = false)
    private String groupName;
    @Column(name="COMPANYID",length = 50,nullable = false)
    private String companyId;

    public String getGroupInfoKey() {
        return groupInfoKey;
    }

    public void setGroupInfoKey(String groupInfoKey) {
        this.groupInfoKey = groupInfoKey;
    }

    public String getGroupInfoId() {
        return groupInfoId;
    }

    public void setGroupInfoId(String groupInfoId) {
        this.groupInfoId = groupInfoId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
