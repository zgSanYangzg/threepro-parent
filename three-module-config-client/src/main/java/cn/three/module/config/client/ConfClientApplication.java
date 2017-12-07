package cn.three.module.config.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfClientApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(ConfClientApplication.class).web(true).run(args);
    }
}
