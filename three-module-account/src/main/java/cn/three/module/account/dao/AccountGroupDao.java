package cn.three.module.account.dao;

import cn.three.core.database.dao.GenericDAO;
import cn.three.module.account.pojo.AccountGroup;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface AccountGroupDao extends GenericDAO<AccountGroup> {
    public int delAccountGroupBy(String groupInfoId, String companyId) throws Exception;
}
