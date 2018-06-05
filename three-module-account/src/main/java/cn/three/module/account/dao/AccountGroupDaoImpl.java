package cn.three.module.account.dao;

import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.module.account.pojo.AccountGroup;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/11.
 */
@Repository(value = "accountGroupDao")
public class AccountGroupDaoImpl extends GenericDAOImpl<AccountGroup> implements AccountGroupDao {

    @Override
    public int delAccountGroupBy(String groupInfoId, String companyId) throws Exception {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> parms = new HashMap<String, Object>();
        sql.append("DELETE FROM DTACCOUNTGROUP D WHERE D.GROUPID=:GROUPID");
        sql.append(" AND COMPANYID=:COMPANYID");
        parms.put("GROUPID", groupInfoId);
        parms.put("COMPANYID", companyId);
        return this.update(sql.toString(), parms);
    }

}
