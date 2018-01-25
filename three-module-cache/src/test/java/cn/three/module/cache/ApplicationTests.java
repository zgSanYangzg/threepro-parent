package cn.three.module.cache;


import cn.three.module.account.pojo.CAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @Test
    public void test() throws Exception {

        CAccount a = new CAccount();
        a.setStaffName("123张三");
        a.setCompanyName("tae");
        Redis.set("213","213");
        Redis.setSingle(a,"company","group","organization");
        System.out.println(Redis.get("213").toString()+"=========================");
        CAccount b =Redis.getSingle(CAccount.class,"company","group","organization");
        System.out.print(b.getStaffName());
    }

}