package cn.three.module.account.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.module.account.pojo.CRole;
import cn.three.module.account.pojo.model.CRoleModel;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Repository(value = "roleDao")
public class RoleDaoImpl extends GenericDAOImpl<CRole> implements RoleDao {

    @Override
    public List<CRole> findRoleBy(String companyId, String orderBy) throws Exception {
        String sql = " AND COMPANYID = :COMPANYID";
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("COMPANYID", companyId);
        return this.find(sql, parms, orderBy, "asc");
    }
    @Override
    public List<CRole> findRoleByPage(CRoleModel model, String orderBy, String order, Page page) throws Exception {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parms = new HashMap<String, Object>();
        sql.append(" AND COMPANYID=:COMPANYID");
        parms.put("COMPANYID", model.getCompanyID());
        return this.paginate(sql.toString(), parms, page, orderBy, order);
    }
    @Override
    public List<Map<String, Object>> findRoleMapBy(List<String> roleids) throws Exception {

        StringBuffer sql = new StringBuffer();
        sql.append("SELECT t.ROLEID roldid,t.ROLENAME rolename FROM ");
        sql.append(this.tableName());
        sql.append(" t WHERE t.ROLEID IN(");
        Map<String, Object> parms = new HashMap<String, Object>();
        for (String roleid : roleids) {
            sql.append("?,");
        }

        sql.deleteCharAt(sql.length()-1) .append(")");
        Query query = this.getEntityManager().createNativeQuery(sql.toString());

        for (int i = 0; i < roleids.size(); i++) {
            query.setParameter(i+1, roleids.get(i));
        }

        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }
}
