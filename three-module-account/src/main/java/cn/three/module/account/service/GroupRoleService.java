package cn.three.module.account.service;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */
public interface GroupRoleService {
    public void saveGroupRole(String companyId, String groupInfoId, List<String> roleIds) throws Exception;

    /**
     * 根据组删除角色
     *
     * @param groupInfoId 组标志
     * @param companyId   公司标志
     * @return true删除成功,false没有可删除数据
     * @throws Exception
     */
    public Boolean delGroupRole(String groupInfoId, String companyId) throws Exception;

    public List<String> findGroupRoleBy(String groupInfoId, String companyId) throws Exception;
}
