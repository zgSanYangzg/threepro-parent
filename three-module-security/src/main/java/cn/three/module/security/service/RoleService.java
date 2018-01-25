package cn.three.module.security.service;

import cn.three.core.database.base.Page;
import cn.three.core.database.service.GenericService;
import cn.three.module.security.model.CRoleModel;
import cn.three.module.security.pojo.CRole;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface RoleService extends GenericService<CRoleModel, CRole> {
    public List<CRoleModel> findRoleBy(String companyId, String orderBy) throws Exception;

    public Page findByPage(CRoleModel model, String orderBy, String order, Page page) throws Exception;

    public CRoleModel saveRole(CRoleModel roleModel) throws Exception;

    public CRoleModel editRole(CRoleModel roleModel) throws Exception;

    public void delRole(String roleKey) throws Exception;

    public CRoleModel findRoleByKey(String roleKey) throws Exception;

}
