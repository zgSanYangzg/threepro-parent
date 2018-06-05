package cn.three.module.account.service;

import cn.three.core.database.base.Page;
import cn.three.module.account.pojo.model.CAccountModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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

    @Test
    public void demoTest() {

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());

       /* // byte
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数："              + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);*/
    }


}
interface A{}
abstract class B  {}
interface A1 extends A{}