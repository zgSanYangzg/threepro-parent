package cn.three.api.account.controller;

import cn.three.core.database.base.Page;
import cn.three.module.account.pojo.model.CRoleModel;
import cn.three.module.account.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/1/4 0004.
 */
@Api(value = "角色管理")
@RestController
@RequestMapping(value = "/ea/ccrole")
public class RoleController {

    @Autowired
    private RoleService service;

    @ApiOperation(value = "增加角色", notes = "saveRole")
    @PostMapping("/ea_savaCRole")
    public CRoleModel saveRole(@RequestBody CRoleModel roleModel) throws Exception {
        return service.saveRole(roleModel);
    }

    @ApiOperation(value = "根据条件查询角色列表",notes = "getRolesBy")
    @ApiImplicitParam(value = "公司标志",name = "companyId",required = true,dataType = "String")
    @GetMapping(value = "/ea_getListCRole")
    public Page getRolesBy(String companyId) throws Exception {
        CRoleModel roleModel  = new CRoleModel ();
        roleModel.setCompanyID(companyId);
        return service.findByPage(roleModel, "", "", new Page(10, 0));
    }

    @ApiOperation(value = "修改角色",notes = "editRole")
    @PostMapping("/ea_editRole")
    public CRoleModel editRole(@RequestBody CRoleModel roleModel) throws Exception {

        return service.editRole(roleModel);
    }

    @ApiOperation(value = "跳转编辑页面",notes = "toPage")
    @GetMapping("/ea_toPage")
    public CRoleModel toPage(String roleKey) throws Exception {
        return service.findRoleByKey(roleKey);
    }

    @ApiOperation(value = "删除角色",notes = "deleteRole")
    @ApiImplicitParam(name = "roleKey",value = "角色的标识",required = true)
    @DeleteMapping("/ea_delCRole")
    public void deleteRole(String roleKey) throws Exception {
        service.delRole(roleKey);
    }

}
