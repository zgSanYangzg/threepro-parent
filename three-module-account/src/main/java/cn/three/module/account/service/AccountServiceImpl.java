package cn.three.module.account.service;

import cn.three.core.database.base.Page;
import cn.three.core.database.service.BaseServiceImpl;
import cn.three.core.foundation.constants.CoreConstants;
import cn.three.core.foundation.util.BeanTool;
import cn.three.core.foundation.util.Encrypt;
import cn.three.core.foundation.util.ValidationUtil;
import cn.three.module.account.dao.CaccountDao;
import cn.three.module.account.pojo.CAccount;
import cn.three.module.account.pojo.CAccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Component(value = "accountService")
public class AccountServiceImpl extends BaseServiceImpl<CAccountModel, CAccount> implements AccountService {
    @Autowired
    private CaccountDao caccountDao;

    public Page findByPage(CAccountModel model, String orderBy, String order, Page page) throws Exception {
        List<CAccount> lst = caccountDao.findBy(model, orderBy, order, page);
        page.setList(BeanTool.toModels(lst, CAccountModel.class));
        return page;
    }
    @Transactional
    public CAccountModel saveCAccount(CAccountModel model) throws Exception {
        CAccount caccount = new CAccount();
        caccount = BeanTool.toPo(model, caccount);
        caccount.setAccountOnLine("00");
        caccount.setAccountPassword(Encrypt.md5ForAuth(caccount.getAccountPassword(), CoreConstants.DEFAULT_SALT));

        if (ValidationUtil.isEmpty(model.getAccountID()) && ValidationUtil.isEmpty(model.getAccountKey())) {
            caccount.setAccountID(UUID.randomUUID().toString());
        }
        caccountDao.insert(caccount);
        return BeanTool.toModel(caccount, model);
    }

    public Long getCaccoutOnLineNumber(CAccountModel model) throws Exception {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> parms = new HashMap<String, Object>();
        sql.append(" and accountOnLine = :accountOnLine");
        parms.put("accountOnLine", "01");
        sql.append(" and companyID = :companyID");
        parms.put("companyID", model.getCompanyID());
        sql.append(" and accountStatus = :accountStatus");
        parms.put("accountStatus", "00");
        return caccountDao.findCount(sql.toString(), parms);
    }

    public CAccountModel findAccountByOne(String accountKey) throws Exception {
        CAccountModel md = new CAccountModel();

        CAccount entity = caccountDao.findById(accountKey);
        return BeanTool.toModel(entity, md);
    }

    @Transactional
    public Boolean changePassWord(String key, String newpass) {
        boolean flag = false;
        try {
            CAccount entity = caccountDao.findById(key);
            entity.setAccountPassword(Encrypt.md5ForAuth(newpass, CoreConstants.DEFAULT_SALT));
            caccountDao.update(entity);
            flag = true;
        } catch (Exception e) {

        }
        return flag;

    }
}
