package cn.three.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@SpringBootApplication
@ComponentScan(basePackages = "cn.three.**")
public class ApiAccountApplication {

    public static void main(String[] args){
        SpringApplication.run(ApiAccountApplication.class,args);
    }
}
