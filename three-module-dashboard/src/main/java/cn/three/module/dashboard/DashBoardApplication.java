package cn.three.module.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Administrator on 2017/11/20 0020.
 */
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class DashBoardApplication {

    public static void main(String[] args){
        SpringApplication.run(DashBoardApplication.class,args);
    }
}
