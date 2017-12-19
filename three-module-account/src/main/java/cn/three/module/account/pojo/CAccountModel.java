package cn.three.module.account.pojo;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/7 0007.
 */
public class CAccountModel {
    private String accountKey;
    private String accountID;
    private String staffID;
    private String companyID;
    private String accountName;
    private String accountEmail;          //用户名
    private String accountPassword;       //密码
    private String roleID;
    private String accountStatus;
    private String accountOnLine;
    private String staffName;


    //非数据库字段
    private String afterStaffID;
    private static Map<String, String> oRmap;
    private String companyName;
    private Staff staff;
    private Company company;//所属公司

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

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyID() {
        return companyID;
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

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountOnLine() {
        return accountOnLine;
    }

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

    public static Map<String, String> getoRmap() {
        return oRmap;
    }

    public static void setoRmap(Map<String, String> oRmap) {
        CAccountModel.oRmap = oRmap;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
