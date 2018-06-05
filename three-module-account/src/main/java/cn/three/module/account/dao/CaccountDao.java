package cn.three.module.account.dao;

import cn.three.core.database.base.Page;
import cn.three.core.database.dao.GenericDAO;
import cn.three.module.account.pojo.CAccount;
import cn.three.module.account.pojo.model.CAccountModel;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
public interface CaccountDao extends GenericDAO<CAccount> {
    public List<CAccount> findBy(CAccountModel model, String orderBy, String order, Page page) throws Exception;

    public String findStaffNameBy(String staffid) throws Exception;

    public void delCAccountBy(String companyId, String key) throws Exception;

    public Long findOnlineBy(String companyId) throws Exception;
}
