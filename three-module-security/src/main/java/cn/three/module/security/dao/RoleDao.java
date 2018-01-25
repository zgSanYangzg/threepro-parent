package cn.three.module.security.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAO;
import cn.three.module.security.model.CRoleModel;
import cn.three.module.security.pojo.CRole;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface RoleDao extends GenericDAO<CRole> {
    public List<CRole> findRoleBy(String companyId, String orderBy) throws Exception;

    public List<CRole> findRoleByPage(CRoleModel model, String orderBy, String order, Page page) throws Exception;
}
