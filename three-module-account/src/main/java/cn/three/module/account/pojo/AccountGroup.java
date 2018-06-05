package cn.three.module.account.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/2.
 */
@Entity
@Table(name = "DTACCOUNTGROUP")
public class AccountGroup implements Serializable {
    @Id
    @GeneratedValue(generator="gd")
    @GenericGenerator(strategy = "guid",name = "gd")
    @Column(name="ACCOUNTGROUPKEY",length = 50,nullable = false)
    private String accountGroupKey;
    @Column(name = "ACCOUNTGROUPID",length = 50)
    private String accountGroupId;
    @Column(name = "COMPANYID",length = 50)
    private String companyId;
    @Column(name = "ACCOUNTID",length = 50)
    private String accountId;
    @Column(name = "GROUPID",length = 50)
    private String groupId;

    public String getAccountGroupKey() {
        return accountGroupKey;
    }

    public void setAccountGroupKey(String accountGroupKey) {
        this.accountGroupKey = accountGroupKey;
    }

    public String getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(String accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
