package cn.three.module.cache;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @Test
    public void test() throws Exception {

        String[] arr = new String[2];
        arr[0]="123张三";
        arr[1]="tae";
        Redis.set("213","213");
        System.out.println(Redis.get("213").toString()+"=========================");
    }
}