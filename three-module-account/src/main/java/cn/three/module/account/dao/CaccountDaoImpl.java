package cn.three.module.account.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.core.foundation.util.StringUtil;
import cn.three.module.account.pojo.CAccount;
import cn.three.module.account.pojo.model.CAccountModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Repository(value = "caccountDao")
public class CaccountDaoImpl extends GenericDAOImpl<CAccount> implements CaccountDao {

    public List<CAccount> findBy(CAccountModel model, String orderBy, String order, Page page) throws Exception {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> parms = new HashMap<String, Object>();
        if (!StringUtil.validateNull(model.getCompanyID())) {
            sql.append(" AND COMPANYID = :COMPANYID");
            parms.put("COMPANYID", model.getCompanyID());
        }
        if (!StringUtil.validateNull(model.getAccountName())) {
            sql.append(" AND ACCOUNTNAME LIKE :ACCOUNTNAME");
            parms.put("ACCOUNTNAME", "%" + model.getAccountName() + "%");
        }
        if (!StringUtil.validateNull(model.getRoleID())) {
            sql.append(" AND ROLEID = :ROLEID");
            parms.put("ROLEID", model.getRoleID());
        }
        if (!StringUtil.validateNull(model.getAccountEmail())) {
            sql.append(" AND ACCOUNTEMAIL LIKE :ACCOUNTEMAIL");
            parms.put("ACCOUNTEMAIL", "%" + model.getAccountEmail() + "%");
        }
        if (!StringUtil.validateNull(model.getAccountStatus())) {
            sql.append(" AND ACCOUNTSTATUS = :ACCOUNTSTATUS");
            parms.put("ACCOUNTSTATUS", model.getAccountStatus());
        }
        if (!StringUtil.validateNull(model.getAccountOnLine())) {
            sql.append(" AND ACCOUNTONLINE = :ACCOUNTONLINE");
            parms.put("ACCOUNTONLINE", model.getAccountOnLine());
        }

        return this.paginate(sql.toString(), parms, page, orderBy, order);
    }

    public String findStaffNameBy(String staffid) throws Exception {
        String sql = "SELECT T.STAFFNAME FROM DT_HR_STAFF T WHERE T.STAFFID = :STAFFID";
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("STAFFID", staffid);
        return this.findObject(sql, parms);
    }

    public void delCAccountBy(String companyId, String key) throws Exception {
        this.delete(key);
        Map<String, Object> parms = new HashMap<String, Object>();
        String sql = "DELETE FROM DTCOA T WHERE T.COMPANYID = :COMPANYID AND T.ACCOUNTID = :ACCOUNTID";
        parms.put("COMPANYID", companyId);
        parms.put("ACCOUNTID", key);
        this.update(sql, parms);
    }

    public Long findOnlineBy(String companyId) throws Exception {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> parms = new HashMap<String, Object>();
        sql.append(" AND ACCOUNTONLINE = :ACCOUNTONLINE");
        parms.put("ACCOUNTONLINE", "01");
        sql.append(" AND COMPANYID = :COMPANYID");
        parms.put("COMPANYID", companyId);
        sql.append(" AND ACCOUNTSTATUS = :ACCOUNTSTATUS");
        parms.put("ACCOUNTSTATUS", "00");
        return this.findCount(sql.toString(), parms);
    }
}
