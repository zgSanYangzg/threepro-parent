package cn.three.module.account.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAO;
import cn.three.module.account.pojo.CRole;
import cn.three.module.account.pojo.model.CRoleModel;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface RoleDao extends GenericDAO<CRole> {
    public List<CRole> findRoleBy(String companyId, String orderBy) throws Exception;

    public List<CRole> findRoleByPage(CRoleModel model, String orderBy, String order, Page page) throws Exception;

    public List<Map<String, Object>> findRoleMapBy(List<String> roleids) throws Exception;
}
