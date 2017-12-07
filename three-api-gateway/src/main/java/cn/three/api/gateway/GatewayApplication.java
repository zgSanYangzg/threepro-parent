package cn.three.api.gateway;

import cn.three.api.gateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/11/24 0024.
 */
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
    }
    //使过滤器生效
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

}
