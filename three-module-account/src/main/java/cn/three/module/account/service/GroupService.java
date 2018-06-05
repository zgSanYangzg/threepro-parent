package cn.three.module.account.service;

import cn.three.core.database.service.GenericService;
import cn.three.module.account.pojo.GroupInfo;
import cn.three.module.account.pojo.model.CAccountModel;
import cn.three.module.account.pojo.model.GroupInfoModel;

/**
 * Created by Administrator on 2018/2/2.
 */
public interface GroupService extends GenericService<GroupInfoModel, GroupInfo> {
    /**
     * 增加用户组
     *
     * @param model
     * @return
     * @throws Exception
     */
    public GroupInfoModel saveGroupInfo(GroupInfoModel model) throws Exception;

    /**
     * 删除用户组
     *
     * @param groupInfoKey
     * @throws Exception
     */
    public void delGroupInfo(String groupInfoKey) throws Exception;

    /**
     * 编辑用户组
     *
     * @param model
     * @return
     * @throws Exception
     */
    public GroupInfoModel editGroupInfo(GroupInfoModel model) throws Exception;

    /**
     * 根据key查询用户组信息
     *
     * @param groupKey
     * @return
     * @throws Exception
     */
    public GroupInfoModel findGroupInfo(String groupKey) throws Exception;

    //根据用户查询用户组
    public GroupInfoModel findGroupBy(String accountId) throws Exception;

    //给用户组分配角色
    public void allotRole(String companyId, String groupId, String[] roleIds) throws Exception;

    //组拥有的角色查询
    public CAccountModel findGroupRoleBy(String companyId, String groupId) throws Exception;

}
