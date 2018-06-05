package cn.three.module.account.service;

import cn.three.core.database.base.Page;
import cn.three.core.database.service.GenericServiceImpl;
import cn.three.core.foundation.constants.MessageConstants;
import cn.three.core.foundation.exceptions.BusinessException;
import cn.three.core.foundation.exceptions.DataNotFoundException;
import cn.three.core.foundation.util.BeanTool;
import cn.three.core.foundation.util.ValidationUtil;
import cn.three.module.account.dao.RoleDao;
import cn.three.module.account.pojo.CRole;
import cn.three.module.account.pojo.model.CAccountModel;
import cn.three.module.account.pojo.model.CRoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Service(value = "roleService")
public class RoleServiceImpl extends GenericServiceImpl<CRoleModel, CRole> implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<CRoleModel> findRoleBy(String companyId, String orderBy) throws Exception {

        if (ValidationUtil.isEmpty(companyId)) {
            throw new ValidationException(MessageConstants.DATA_VALIDATION_FAILED);
        }
        List<CRole> lst = this.roleDao.findRoleBy(companyId, orderBy);
        return BeanTool.toModels(lst, CRoleModel.class);
    }

    public Page findByPage(CRoleModel model, String orderBy, String order, Page page) throws Exception {
        List<CRole> lst = roleDao.findRoleByPage(model, orderBy, order, page);
        page.setList(BeanTool.toModels(lst, CRoleModel.class));
        return page;
    }

    @Transactional
    public CRoleModel saveRole(CRoleModel roleModel) throws Exception {

        CRole entity = new CRole();
        BeanTool.copyExistPropertis(roleModel, entity);
        entity.setRoleID(UUID.randomUUID().toString());
        roleDao.insert(entity);
        return BeanTool.toModel(entity, roleModel);
    }

    @Transactional
    public CRoleModel editRole(CRoleModel roleModel) throws Exception {
        CRole entity = roleDao.findById(roleModel.getRoleKey());
        if (ValidationUtil.isEmpty(entity)) {
            throw new DataNotFoundException(MessageConstants.DATA_NOT_FOUND);
        }
        BeanTool.copyExistPropertis(roleModel, entity);
        roleDao.update(entity);
        return BeanTool.toModel(entity, roleModel);
    }

    @Transactional
    public void delRole(String roleKey) throws Exception {
        CRole entity = roleDao.findById(roleKey);
        if (ValidationUtil.isEmpty(entity)) {
            throw new DataNotFoundException(MessageConstants.DATA_NOT_FOUND);
        }
        roleDao.delete(roleKey);
    }

    public CRoleModel findRoleByKey(String roleKey) throws Exception {
        CRole enttiy = roleDao.findById(roleKey);
        if (ValidationUtil.isEmpty(enttiy)) {
            throw new DataNotFoundException(MessageConstants.DATA_NOT_FOUND);
        }
        return BeanTool.toModel(enttiy, new CRoleModel());
    }

    @Override
    public CAccountModel findRoleBy(List<String> roleids,CAccountModel model) throws Exception {
        if(roleids.size()<1){
            throw new BusinessException(MessageConstants.DATA_VALIDATION_FAILED);
        }
        List<Map<String, Object>> roleList = roleDao.findRoleMapBy(roleids);

        StringBuilder ids = new StringBuilder();
        StringBuilder names = new StringBuilder();
        for (Map<String, Object> sn : roleList) {
            if (ids.indexOf(sn.get("roldid").toString()) > -1) {
                continue;
            }
            ids.append(sn.get("roldid")).append(",");
            names.append(sn.get("rolename")).append(",");
        }

        if (ValidationUtil.isEmpty(ids.toString())) {
            ids.deleteCharAt(ids.length() - 1);
        }
        if (ValidationUtil.isEmpty(names.toString())) {
            names.deleteCharAt(names.length() - 1);
        }
        model.setRoleIds(ids.toString());
        model.setRoleNames(names.toString());

        return model;
    }

}
