package cn.three.api.account.controller;

import cn.three.core.foundation.constants.CoreConstants;
import cn.three.core.foundation.util.ValidationUtil;
import cn.three.module.account.pojo.GroupInfo;
import cn.three.module.account.pojo.model.CAccountModel;
import cn.three.module.account.pojo.model.GroupInfoModel;
import cn.three.module.account.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/3/7.
 */
@Api(value = "用户组管理")
@RestController
@RequestMapping(value = "/ea/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    //增加用户组


    @ApiOperation(value = "增加用户组", notes = "增加用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true),
            @ApiImplicitParam(name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(name = "groupName", value = "组名称", required = true)
    })
    @GetMapping("/ea_addUserGroup")
    public GroupInfoModel addUserGroup(String companyId, String userId, String groupName) {

        GroupInfoModel model = new GroupInfoModel();
        if (ValidationUtil.isEmpty(companyId) && ValidationUtil.isEmpty(userId) && ValidationUtil.isEmpty(groupName)) {
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            model.setDescription("参数存在空值");
            return model;
        }

        model.setCompanyId(companyId);
        model.setAccountId(userId);
        model.setGroupName(groupName);
        try {
            model = groupService.saveGroupInfo(model);
            model.setRecStatus(CoreConstants.COMMON_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            model.setDescription("save方法异常");
        }
        return model;
    }


    //删除用户组
    @ApiOperation(value = "删除用户组", notes = "删除用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "groupKey", name = "用户组标识", required = true)
    })
    @PutMapping("/ea_deleteUserGroup")
    public GroupInfoModel deleteUserGroup(String groupKey) {
        GroupInfoModel model = new GroupInfoModel();

        if (ValidationUtil.isEmpty(groupKey)) {
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            model.setDescription("参数为空");
            return model;
        }
        try {
            groupService.delGroupInfo(groupKey);
            model.setRecStatus(CoreConstants.COMMON_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            model.setDescription("删除组过程异常");
        }
        return model;
    }

    //查询用户组
    @ApiOperation(value = "查询用户组", notes = "查询用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "userId", name = "用户id", required = true)
    })
    @GetMapping("/ea_findUserGroup")
    public GroupInfoModel findUserGroup(String userId) {
        GroupInfoModel model = new GroupInfoModel();

        if (ValidationUtil.isEmpty(userId)) {
            model.setDescription("参数有空值");
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            return model;
        }
        try {
            groupService.findGroupBy(userId);
            model.setRecStatus(CoreConstants.COMMON_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            model.setDescription("查询方法异常");
            model.setRecStatus(CoreConstants.COMMON_FALSE);
        }
        return model;
    }

    //查询用户拥有角色
    @ApiOperation(value = "查询用户拥有角色", notes = "查询用户拥有角色")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "companyId", name = "公司id", required = true),
            @ApiImplicitParam(value = "groupId", name = "组id", required = true)
    })
    @GetMapping("/ea_findUserRole")
    public CAccountModel findUserRole(String companyId, String groupId) {
        CAccountModel model = new CAccountModel();

        if (ValidationUtil.isEmpty(companyId) || ValidationUtil.isEmpty(groupId)) {
            model.setDescription("参数有空值");
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            return model;
        }
        try {
            groupService.findGroupRoleBy(companyId, groupId);
            model.setRecStatus(CoreConstants.COMMON_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            model.setDescription("查询方法异常");
            model.setRecStatus(CoreConstants.COMMON_FALSE);
        }
        return model;
    }

    //给用户组分配角色
    @ApiOperation(value = "给用户组分配角色", notes = "给用户组分配角色")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "companyId", name = "公司id", required = true),
            @ApiImplicitParam(value = "groupId", name = "组id", required = true),
            @ApiImplicitParam(value = "roleId", name = "角色id,数组形式,至少一个", dataType = "数组", required = true)
    })
    @PostMapping("/ea_allotGroupRole")
    public GroupInfoModel allotGroupRole(String companyId, String groupId, String[] roleId) {
        GroupInfoModel model = new GroupInfoModel();

        if (ValidationUtil.isEmpty(companyId) || ValidationUtil.isEmpty(groupId) || ValidationUtil.isEmpty(roleId)) {
            model.setDescription("参数存在空值");
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            return model;
        }
        try {
            groupService.allotRole(companyId, groupId, roleId);
            model.setRecStatus(CoreConstants.COMMON_SUCCESS);
        } catch (Exception e) {
            model.setDescription("分配过程失败");
            model.setRecStatus(CoreConstants.COMMON_FALSE);
            e.printStackTrace();
        }
        return model;
    }
}
