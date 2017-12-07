package cn.three.module.fegin.service;

import cn.three.module.fegin.bo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 此方式需要复制原有接口内容以及实体类
 * 此方式可以单独实现服务降级
 * Created by Administrator on 2017/11/21 0021.
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader("name") String name , @RequestHeader("age") Integer age);
    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user);

}
