package cn.three.api.account.controller;

import cn.three.core.database.base.Page;
import cn.three.module.account.pojo.model.CAccountModel;
import cn.three.module.account.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@Api(value = "帐号管理")
@RestController
@RequestMapping(value = "/ea/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @ApiOperation(value = "根据公司标识获取所有帐号", notes = "getListCaccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司标识", required = true),
            @ApiImplicitParam(name = "accountName", value = "昵称", required = false),
            @ApiImplicitParam(name = "roleID", value = "角色id", required = false),
            @ApiImplicitParam(name = "accountEmail", value = "帐号", required = false),
            @ApiImplicitParam(name = "accountStatus", value = "帐号状态", required = false),
            @ApiImplicitParam(name = "accountOnLine", value = "在线状态", required = false)
    })
    @GetMapping("/ea_getListCAccount")
    public Page getListCaccount(String companyId, String accountName, String roleID,
                                String accountEmail, String accountStatus, String accountOnLine
    ) throws Exception {
        CAccountModel cmodel = new CAccountModel();

        cmodel.setCompanyID(companyId);
        return service.findByPage(cmodel, "", "", new Page(10, 0));
    }

    @ApiOperation(value = "跳转修改页面", notes = "toEditPage")
    @ApiImplicitParam(name = "key", value = "主键key", required = true)
    @GetMapping("/ea_toEditPage")
    public CAccountModel toEditPage(String key) throws Exception {

        CAccountModel model = service.findAccountByOne(key);
        return model;
    }

    @ApiOperation(value = "增加用户", notes = "保存帐号方法saveCaccount")
    @PostMapping("/ea_saveCaccount")
    public CAccountModel saveCaccount(@RequestBody CAccountModel caccountModel) throws Exception {
        return service.saveCAccount(caccountModel);
    }

    @ApiOperation(value = "修改用户", notes = "editCaccount")
    @PostMapping("/ea_editCaccount")
    public CAccountModel editCaccount(@RequestBody CAccountModel caccountModel) throws Exception {

        return service.updateCaccount(caccountModel);
    }

    @ApiOperation(value = "删除用户", notes = "delCaccount")
    @ApiImplicitParam(name = "accountKey", value = "帐号key", required = true)
    @DeleteMapping("/ea_delCaccount")
    public void delCaccount(String accountKey) throws Exception {
        service.delCAccount(accountKey);

    }
    //禁用用户

}
