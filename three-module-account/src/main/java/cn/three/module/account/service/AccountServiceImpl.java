package cn.three.module.account.service;

import cn.three.core.database.base.Page;
import cn.three.core.database.service.GenericServiceImpl;
import cn.three.core.foundation.constants.CoreConstants;
import cn.three.core.foundation.constants.MessageConstants;
import cn.three.core.foundation.exceptions.BusinessException;
import cn.three.core.foundation.exceptions.DataValidateException;
import cn.three.core.foundation.util.BeanTool;
import cn.three.core.foundation.util.Encrypt;
import cn.three.core.foundation.util.ValidationUtil;
import cn.three.module.account.dao.CaccountDao;
import cn.three.module.account.pojo.CAccount;
import cn.three.module.account.pojo.CAccountModel;
import cn.three.module.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Service(value = "accountService")
public class AccountServiceImpl extends GenericServiceImpl<CAccountModel, CAccount> implements AccountService {
    @Autowired
    private CaccountDao caccountDao;

    @Autowired
    private RoleService roleService;


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

        if (ValidationUtil.isEmpty(model.getCompany())) {
            throw new BusinessException(MessageConstants.DATA_VALIDATION_FAILED);
        }

        return caccountDao.findOnlineBy(model.getCompanyID());
    }

    public CAccountModel findAccountByOne(String accountKey) throws Exception {
        CAccountModel md = new CAccountModel();
        CAccount entity = caccountDao.findById(accountKey);
        if (ValidationUtil.isEmpty(entity)) {
            throw new BusinessException(MessageConstants.DATA_NOT_FOUND);
        }
        entity.setStaffName(caccountDao.findStaffNameBy(entity.getStaffID()));
        md = BeanTool.toModel(entity, md);
        md.setAcctRoles(roleService.findRoleBy(entity.getCompanyID(), ""));
        return md;
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

    @Transactional
    public void delCAccount(String acntkey) throws Exception {
        CAccount act = caccountDao.findById(acntkey);
        if (ValidationUtil.isEmpty(act.getAccountID()) || ValidationUtil.isEmpty(act.getCompanyID())) {
            throw new BusinessException("无法根据公司id和账户标识查询角色");
        }
        caccountDao.delCAccountBy(act.getCompanyID(), act.getAccountKey());
    }

    @Transactional
    public CAccountModel updateCaccount(CAccountModel updateModel) throws Exception {

        CAccount oldEntity = caccountDao.findById(updateModel.getAccountKey());

        if (ValidationUtil.isEmpty(oldEntity)) {
            throw new DataValidateException(MessageConstants.DATA_NOT_FOUND);
        }

        BeanTool.copyExistPropertis(updateModel, oldEntity);

        caccountDao.update(oldEntity);

        return BeanTool.toModel(oldEntity, updateModel);
    }
}
