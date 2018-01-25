package cn.three.module.account.service;

import cn.three.core.database.base.Page;
import cn.three.core.database.service.GenericService;
import cn.three.module.account.pojo.CAccount;
import cn.three.module.account.pojo.CAccountModel;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
public interface AccountService extends GenericService<CAccountModel, CAccount> {
    public Page findByPage(CAccountModel model, String orderBy, String order, Page page) throws Exception;

    public Long getCaccoutOnLineNumber(CAccountModel model) throws Exception;

    public CAccountModel saveCAccount(CAccountModel model) throws Exception;

    public CAccountModel findAccountByOne(String accountKey) throws Exception;

    public Boolean changePassWord(String key, String newpass);

    public void delCAccount(String acntkey) throws Exception;

    public CAccountModel updateCaccount(CAccountModel updateModel) throws Exception;
}
