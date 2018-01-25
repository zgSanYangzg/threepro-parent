package cn.three.module.account.service;

import cn.three.core.database.base.Page;
import cn.three.module.account.pojo.CAccountModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CaccountServiceTests {
    @Autowired
    AccountService accountService;

    @Test
    public void findByTest() {
        CAccountModel m = new CAccountModel();
        m.setCompanyID("company201009046vxdyzy4wg0000000025");
        m.setAccountEmail("test");
        Page page = new Page(10, 0);
        try {
            accountService.findByPage(m, "", "", page);
            for (Object obj : page.getList()) {
                CAccountModel tm = (CAccountModel) obj;

                System.out.println(tm.getAccountKey());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCaccoutOnLineNumberTest() {
        CAccountModel m = new CAccountModel();
        m.setCompanyID("company201009046vxdyzy4wg0000000025");
        try {
            Long a = accountService.getCaccoutOnLineNumber(m);
            System.out.print(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void accountTest() {
        CAccountModel m = new CAccountModel();
        m.setStaffID("cstaff201601229QHAIZP9560000000021");
        m.setCompanyID("company201009046vxdyzy4wg0000000025");
        m.setAccountName("test");
        m.setAccountEmail("test");
        m.setAccountPassword("123456");
        m.setRoleID("crole201009046vxdyzy4wg0000000030");
        m.setAccountStatus("00");
        m.setAccountOnLine("00");
        m.setStaffName("test");
        try {
            m = accountService.saveCAccount(m);
            m.setAccountEmail("editest");
            accountService.updateCaccount(m);
            m = accountService.findAccountByOne(m.getAccountKey());
            if (m.getAccountEmail().equals("editest")) {
                if (accountService.changePassWord(m.getAccountKey(), "456789")) {
                    accountService.delCAccount(m.getAccountKey());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
