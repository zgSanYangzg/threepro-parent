package cn.three.module.security.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.module.security.model.CRoleModel;
import cn.three.module.security.pojo.CRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Repository(value = "roleDao")
public class RoleDaoImpl extends GenericDAOImpl<CRole> implements RoleDao {

    public List<CRole> findRoleBy(String companyId, String orderBy) throws Exception {
        String sql = " AND COMPANYID = :COMPANYID";
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("COMPANYID", companyId);
        return this.find(sql, parms, orderBy, "asc");
    }

    public List<CRole> findRoleByPage(CRoleModel model, String orderBy, String order, Page page) throws Exception {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parms = new HashMap<String, Object>();
        sql.append(" AND COMPANYID=:COMPANYID");
        parms.put("COMPANYID", model.getCompanyID());
        return this.paginate(sql.toString(), parms, page, orderBy, order);
    }
}
