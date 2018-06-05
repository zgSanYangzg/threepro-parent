package cn.three.module.account.service;

import cn.three.core.database.service.GenericServiceImpl;
import cn.three.core.foundation.constants.MessageConstants;
import cn.three.core.foundation.exceptions.BusinessException;
import cn.three.core.foundation.util.BeanTool;
import cn.three.core.foundation.util.ValidationUtil;
import cn.three.module.account.dao.AccountGroupDao;
import cn.three.module.account.dao.GroupInfoDao;
import cn.three.module.account.pojo.AccountGroup;
import cn.three.module.account.pojo.GroupInfo;
import cn.three.module.account.pojo.model.CAccountModel;
import cn.three.module.account.pojo.model.GroupInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户组管理
 * Created by Administrator on 2018/2/2.
 */
@Service(value = "groupService")
public class GroupServiceImpl extends GenericServiceImpl<GroupInfoModel, GroupInfo> implements GroupService {

    @Autowired
    private GroupInfoDao groupInfoDao;
    @Autowired
    private GroupRoleService groupRoleService;
    @Autowired
    private AccountGroupDao accountGroupDao;
    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public GroupInfoModel saveGroupInfo(GroupInfoModel model) throws Exception {
        GroupInfo entity = new GroupInfo();
        BeanTool.copyExistPropertis(model, entity);
        entity.setGroupInfoId(UUID.randomUUID().toString());
        groupInfoDao.insert(entity);
        BeanTool.toModel(entity, model);

        AccountGroup agEntity = new AccountGroup();
        agEntity.setAccountGroupId(UUID.randomUUID().toString());
        agEntity.setAccountId(model.getAccountId());
        agEntity.setGroupId(model.getGroupInfoId());
        agEntity.setCompanyId(model.getCompanyId());
        accountGroupDao.insert(agEntity);
        return model;
    }

    @Transactional
    @Override
    public void delGroupInfo(String groupInfoKey) throws Exception {
        GroupInfo entity = groupInfoDao.findById(groupInfoKey);
        if (ValidationUtil.isEmpty(entity)) {
            throw new BusinessException(MessageConstants.DATA_VALIDATION_FAILED);
        }

        groupRoleService.delGroupRole(entity.getGroupInfoId(), entity.getCompanyId());
        accountGroupDao.delAccountGroupBy(entity.getGroupInfoId(), entity.getCompanyId());
        groupInfoDao.delete(groupInfoKey);

    }

    @Transactional
    @Override
    public GroupInfoModel editGroupInfo(GroupInfoModel model) throws Exception {

        GroupInfo entity = this.groupInfoDao.findById(model.getGroupInfoKey());

        if (ValidationUtil.isEmpty(entity)) {
            throw new BusinessException(MessageConstants.DATA_NOT_FOUND);
        }
        BeanTool.copyExistPropertis(model, entity);
        groupInfoDao.update(entity);
        return BeanTool.toModel(entity, model);
    }

    @Override
    public GroupInfoModel findGroupInfo(String groupKey) throws Exception {
        if (ValidationUtil.isEmpty(groupKey)) {
            throw new BusinessException(MessageConstants.DATA_VALIDATION_FAILED);
        }
        GroupInfoModel model = new GroupInfoModel();
        GroupInfo entity = groupInfoDao.findById(groupKey);
        BeanTool.toModel(entity, model);
        return model;
    }

    @Override
    public GroupInfoModel findGroupBy(String accountId) throws Exception {
        GroupInfoModel groupInfoModel = new GroupInfoModel();
        List<String> groupIds = groupInfoDao.findGroupBy(accountId);//组id

        if (ValidationUtil.isEmpty(groupIds)) {
            throw new BusinessException(MessageConstants.DATA_NOT_FOUND);
        }
        List<Map<String, String>> list = groupInfoDao.findGroupInfo(groupIds);
        StringBuilder strgids = new StringBuilder();
        StringBuilder strgnames = new StringBuilder();
        if (!ValidationUtil.isEmpty(list)) {
            for (Map<String, String> map : list) {
                strgids.append(map.get("groupId")).append(",");
                strgnames.append(map.get("groupName")).append(",");
            }
        }
        groupInfoModel.setGroupIds(strgids.deleteCharAt(strgids.length() - 1).toString());
        groupInfoModel.setGroupNames(strgnames.deleteCharAt(strgnames.length() - 1).toString());
        return groupInfoModel;
    }

    @Transactional
    @Override
    public void allotRole(String companyId, String groupId, String[] roleIds) throws Exception {

        List<String> parms = new ArrayList<String>();
        for (String roleId : roleIds) {
            if (!ValidationUtil.isEmpty(roleId)) {
                parms.add(roleId);
            }
        }

        groupRoleService.saveGroupRole(companyId, groupId, parms);
    }

    @Override
    public CAccountModel findGroupRoleBy(String companyId, String groupId) throws Exception {

        CAccountModel model = new CAccountModel();
        model.setCompanyID(companyId);
        model.setGroupId(groupId);
        List<String> roleIds = groupRoleService.findGroupRoleBy(groupId, companyId);//roleid
        if(roleIds.size()>0){
            model = roleService.findRoleBy(roleIds, model);
        }
        return model;
    }
}
