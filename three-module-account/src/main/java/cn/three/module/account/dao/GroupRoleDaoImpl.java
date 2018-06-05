package cn.three.module.account.dao;

import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.module.account.pojo.GroupRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/3.
 */
@Repository(value = "groupRoleDao")
public class GroupRoleDaoImpl extends GenericDAOImpl<GroupRole> implements GroupRoleDao {

    @Override
    public int delGroupRoleBy(String groupInfoId, String companyId) throws Exception {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> parms = new HashMap<String, Object>();
        sql.append("DELETE FROM DT_GROUP_ROLE D WHERE D.GROUPINFOID=:GROUPINFOID");
        sql.append(" AND COMPANYID=:COMPANYID");
        parms.put("GROUPINFOID", groupInfoId);
        parms.put("COMPANYID", companyId);
        return this.update(sql.toString(), parms);
    }
    @Override
    public List<String> findGroupRoleBy(String groupInfoId, String companyId) throws Exception {

        String sql = "SELECT T.ROLEID FROM DT_GROUP_ROLE T WHERE T.COMPANYID=:COMPANYID AND T.GROUPROLEID=:GROUPROLEID";
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("COMPANYID", companyId);
        parms.put("GROUPROLEID", groupInfoId);

        return this.findObjects(sql, parms);
    }
}
