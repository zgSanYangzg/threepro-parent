package cn.three.module.hello.controller;

import cn.three.api.bo.User;
import cn.three.api.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@RestController
public class RefactorHelloController implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello "+name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(1L,name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello "+user.getName()+", "+user.getAge();
    }
}
