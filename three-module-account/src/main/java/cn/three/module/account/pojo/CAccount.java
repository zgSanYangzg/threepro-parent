package cn.three.module.account.pojo;

import cn.three.core.foundation.util.ValidationUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * 帐号管理
 * @author IT
 *
 */
@Entity
@Table(name = "DTCACCOUNT")
public class CAccount implements Serializable {
    @Id
    @GeneratedValue(generator="gd")
    @GenericGenerator(strategy = "guid",name = "gd")
    @Column(name="ACCOUNTKEY",length = 50,nullable = false)
	private String accountKey;
    @Column(name = "ACCOUNTID",length = 50)
    private String accountID;
    @Column(name = "STAFFID",length = 50)
    private String staffID;
    @Column(name = "COMPANYID",length = 50)
    private String companyID;
    @Column(name = "ACCOUNTNAME",length = 250)
    private String accountName;
    @Column(name = "ACCOUNTEMAIL",length = 250)
    private String accountEmail;          //用户名
    @Column(name = "ACCOUNTPASSWORD",length = 250)
    private String accountPassword;       //密码
    @Column(name = "ROLEID",length = 250)
    private String roleID;
    /**
     * 00:正常    02：停用
     */
    @Column(name = "ACCOUNTSTATUS",length = 2)
    private String accountStatus;
    /**
     * 01:在线　　00:不在线
     */
    @Column(name = "ACCOUNTONLINE",length = 2)
    private String accountOnLine;
    //非数据库字段
    @Transient
    private String staffName;
    //非数据库字段
    @Transient
    private String afterStaffID;

    @Transient
    private static Map<String, String> oRmap;

    @Transient
    private String companyName;
    @Transient
    private Staff staff;
    @Transient
    private Company company;//所属公司
	
	public CAccount(Company company, Staff staff) {
		super();
		this.company=company;
		this.staff=staff;
		//this.accountID=accountID;
	}
	public CAccount(){}
	public String getCompanyName() {
		if(!ValidationUtil.isEmpty(company)&&!ValidationUtil.isEmpty(company.getCompanyName())){
			companyName=company.getCompanyName();
		}
		return companyName;
	}
	public static void setoRmap(Map<String, String> oRmap) {
		CAccount.oRmap = oRmap;
	}
	public String getAccountKey() {
		return accountKey;
	}
	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	/**
	 * 00:正常    02：停用
	 * @return
	 */
	public String getAccountStatus() {
		return accountStatus;
	}
	/**
	 * 00:正常    02：停用
	 * @param accountStatus
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	/**
	 * 01:在线　　00:不在线 
	 * @return
	 */
	public String getAccountOnLine() {
		return accountOnLine;
	}
	/**
	 * 01:在线　　00:不在线 
	 * @param accountOnLine
	 */
	public void setAccountOnLine(String accountOnLine) {
		this.accountOnLine = accountOnLine;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getAfterStaffID() {
		return afterStaffID;
	}
	public void setAfterStaffID(String afterStaffID) {
		this.afterStaffID = afterStaffID;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
