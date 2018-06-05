package cn.three.module.account.dao;

import cn.three.core.database.dao.GenericDAO;
import cn.three.module.account.pojo.GroupInfo;
import cn.three.module.account.pojo.GroupRole;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/2.
 */
public interface GroupInfoDao extends GenericDAO<GroupInfo> {
    public List<GroupRole> findRoleBy(String groupId) throws Exception;

    public List<String> findGroupBy(String accountId) throws Exception;

    /**
     * 根据组id查询组名称
     *
     * @param groupids
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findGroupInfo(List<String> groupids) throws Exception;
}
