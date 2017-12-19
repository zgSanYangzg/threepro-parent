package cn.three.api.account.controller;

import cn.three.core.database.base.Page;
import cn.three.module.account.pojo.CAccountModel;
import cn.three.module.account.service.AccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@RestController
@RequestMapping(value = "/ea/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @ApiOperation(value = "获取所有帐号", notes = "根据公司标识获取所有帐号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司标识", required = true, paramType = "path"),
            @ApiImplicitParam(name = "accountName", value = "昵称", required = false, paramType = "path"),
            @ApiImplicitParam(name = "roleID", value = "角色id", required = false, paramType = "path"),
            @ApiImplicitParam(name = "accountEmail", value = "帐号", required = false, paramType = "path"),
            @ApiImplicitParam(name = "accountStatus", value = "帐号状态", required = false, paramType = "path"),
            @ApiImplicitParam(name = "accountOnLine", value = "在线状态", required = false, paramType = "path")
    })
    @GetMapping("/ea_getListCAccount")
    public Page getListCAccount(String companyId, String accountName, String roleID,
                                                   String accountEmail, String accountStatus, String accountOnLine
    ) throws Exception {
        CAccountModel cmodel = new CAccountModel();

        cmodel.setCompanyID(companyId);
        return service.findByPage(cmodel,"","",new Page(10,0));
    }
}
