package cn.three.module.fegin.service;

import cn.three.api.bo.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
//@Component
public class RefactorHelloServiceFallback implements cn.three.api.service.HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "eoor";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(1L,"未知",0);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "eoor";
    }
}
