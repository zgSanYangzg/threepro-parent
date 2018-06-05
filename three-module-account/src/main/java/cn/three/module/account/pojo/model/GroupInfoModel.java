package cn.three.module.account.pojo.model;

import cn.three.core.database.base.BaseModel;

/**
 * Created by Administrator on 2018/2/2.
 */
public class GroupInfoModel extends BaseModel{
    private String groupInfoKey;
    private String groupInfoId;
    private String groupName;
    private String groupSn;
    private String companyId;


    private String groupRoleKey;
    private String groupRoleId;
    private String roleId;

    private String roleIds;
    private String roleNames;

    private String groupIds;
    private String groupNames;

    private String accountId;

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

    public String getGroupSn() {
        return groupSn;
    }

    public void setGroupSn(String groupSn) {
        this.groupSn = groupSn;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    public String getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(String groupNames) {
        this.groupNames = groupNames;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupInfoModel{");
        sb.append("groupInfoKey='").append(groupInfoKey).append('\'');
        sb.append(", groupInfoId='").append(groupInfoId).append('\'');
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", groupSn='").append(groupSn).append('\'');
        sb.append(", companyId='").append(companyId).append('\'');
        sb.append(", groupRoleKey='").append(groupRoleKey).append('\'');
        sb.append(", groupRoleId='").append(groupRoleId).append('\'');
        sb.append(", roleId='").append(roleId).append('\'');
        sb.append(", roleIds='").append(roleIds).append('\'');
        sb.append(", roleNames='").append(roleNames).append('\'');
        sb.append(", groupIds='").append(groupIds).append('\'');
        sb.append(", groupNames='").append(groupNames).append('\'');
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
