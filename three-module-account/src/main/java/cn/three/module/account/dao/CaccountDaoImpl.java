package cn.three.module.account.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.core.foundation.util.StringUtil;
import cn.three.module.account.pojo.CAccount;
import cn.three.module.account.pojo.CAccountModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Repository(value="caccountDao")
public class CaccountDaoImpl extends GenericDAOImpl<CAccount> implements CaccountDao {

    public List<CAccount> findBy(CAccountModel model, String orderBy, String order, Page page) throws Exception{
        StringBuilder sql = new StringBuilder();
        Map<String,Object> parms = new HashMap<String,Object>();
        if (!StringUtil.validateNull(model.getCompanyID())) {
            sql.append(" and companyID = :companyID");
            parms.put("companyID",model.getCompanyID());
        }
        if (!StringUtil.validateNull(model.getAccountName())) {
            sql.append(" and accountName like :accountName");
            parms.put("accountName","%"+model.getAccountName()+"%");
        }
        if (!StringUtil.validateNull(model.getRoleID())) {
            sql.append(" and roleID = :roleID");
            parms.put("roleID", model.getRoleID());
        }
        if (!StringUtil.validateNull(model.getAccountEmail())) {
            sql.append(" and accountEmail like :accountEmail");
            parms.put("accountEmail", "%"+model.getAccountEmail()+"%");
        }
        if (!StringUtil.validateNull(model.getAccountStatus())) {
            sql.append(" and accountStatus = :accountStatus");
            parms.put("accountStatus", model.getAccountStatus());
        }
        if (!StringUtil.validateNull(model.getAccountOnLine())) {
            sql.append(" and accountOnLine = :accountOnLine");
            parms.put("accountOnLine", model.getAccountOnLine());
        }

        return this.paginate(sql.toString(),parms,page,orderBy,order);
    }
}
