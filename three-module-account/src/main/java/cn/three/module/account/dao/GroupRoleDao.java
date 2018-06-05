package cn.three.module.account.dao;

import cn.three.core.database.dao.GenericDAO;
import cn.three.module.account.pojo.GroupRole;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
public interface GroupRoleDao extends GenericDAO<GroupRole> {
    public int delGroupRoleBy(String groupInfoId, String companyId) throws Exception;

    public List<String> findGroupRoleBy(String groupInfoId, String companyId) throws Exception;
}
