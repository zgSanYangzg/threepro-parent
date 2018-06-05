package cn.three.module.account.service;

import cn.three.core.foundation.constants.MessageConstants;
import cn.three.core.foundation.exceptions.BusinessException;
import cn.three.core.foundation.util.ValidationUtil;
import cn.three.module.account.dao.AccountGroupDao;
import cn.three.module.account.dao.GroupRoleDao;
import cn.three.module.account.pojo.GroupRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Administrator on 2018/2/3.
 */
@Service(value = "groupRoleService")
public class GroupRoleServiceImpl implements GroupRoleService {

    @Autowired
    private GroupRoleDao groupRoleDao;


    @Transactional
    @Override
    public void saveGroupRole(String companyId, String groupInfoId, List<String> roleIds) throws Exception {

        this.delGroupRole(groupInfoId, companyId);

        List<GroupRole> lst = new ArrayList<GroupRole>();

        GroupRole entity = new GroupRole();
        entity.setGroupRoleId(UUID.randomUUID().toString());
        entity.setGroupInfoId(groupInfoId);
        entity.setCompanyId(companyId);

        GroupRole temp = null;
        for (String roleId : roleIds) {
            temp = new GroupRole();
            BeanUtils.copyProperties(entity, temp);
            temp.setRoleId(roleId);
            lst.add(temp);
        }
        groupRoleDao.insertList(lst);
    }

    @Transactional
    @Override
    public Boolean delGroupRole(String groupInfoId, String companyId) throws Exception {

        if (ValidationUtil.isEmpty(companyId)) {
            throw new BusinessException("变量:companyId null," + MessageConstants.DATA_VALIDATION_FAILED);
        }
        if (ValidationUtil.isEmpty(groupInfoId)) {
            throw new BusinessException("变量:groupInfoId null," + MessageConstants.DATA_VALIDATION_FAILED);
        }
        int ret = groupRoleDao.delGroupRoleBy(groupInfoId, companyId);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<String> findGroupRoleBy(String groupInfoId, String companyId) throws Exception {

        if (ValidationUtil.isEmpty(groupInfoId)) {
            throw new BusinessException("变量:groupInfoId 为空," + MessageConstants.DATA_VALIDATION_FAILED);
        }
        if (ValidationUtil.isEmpty(companyId)) {
            throw new BusinessException("变量:companyId 为空," + MessageConstants.DATA_VALIDATION_FAILED);
        }

        return groupRoleDao.findGroupRoleBy(groupInfoId, companyId);
    }
}
