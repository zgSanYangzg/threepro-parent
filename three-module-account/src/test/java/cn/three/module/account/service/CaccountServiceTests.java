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
    public void findByTest(){
        CAccountModel m = new CAccountModel();
        m.setCompanyID("company201009046vxdyzy4wg0000000025");
        m.setAccountEmail("牛");
        Page page = new Page(10,0);
        try {
            accountService.findByPage(m,"","",page);
            System.out.print(page.getList().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCaccoutOnLineNumberTest(){
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
    public void saveTest(){
        CAccountModel m = new CAccountModel();
        m.setAccountID("52e70eeb-c814-4257-ab26-266ce8c24772");
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
            accountService.saveCAccount(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findOneTest(){
        CAccountModel m =null;
        try {
            m=accountService.findAccountByOne("64AFA14BB4AB4E719B543C30DEC7CA52");
            System.out.print("findOneTest---"+m.getAccountEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void changePassTest(){
       boolean fg =  accountService.changePassWord("64AFA14BB4AB4E719B543C30DEC7CA52","321321");
       if(fg){
           System.out.print("succ");
       }else{
           System.out.print("false");
       }
    }
}
