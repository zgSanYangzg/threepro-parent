package cn.three.module.fegin.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 劣:此方式引用单独封装的api服务,简单之余内嵌度高,牵一发动全身</br>
 * (慎重)设计时候严格遵照开闭原则
 * Created by Administrator on 2017/11/21 0021.
 */
@FeignClient(value = "hello-service")//,fallback = RefactorHelloServiceFallback.class 测试未通过
public interface RefactorHelloService extends cn.three.api.service.HelloService {
}
