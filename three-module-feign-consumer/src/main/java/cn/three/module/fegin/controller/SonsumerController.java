package cn.three.module.fegin.controller;

import cn.three.module.fegin.bo.User;
import cn.three.module.fegin.service.HelloService;
import cn.three.module.fegin.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@RestController
public class SonsumerController {
    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }
    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){

        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("zg")).append("\n");
        sb.append(helloService.hello("zg",12)).append("\n");
        sb.append(helloService.hello(new User(2L,"ss",33))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("zg")).append("\n");
        sb.append(refactorHelloService.hello("zg",12)).append("\n");
        sb.append(refactorHelloService.hello(new cn.three.api.bo.User(2L,"ss",33))).append("\n");
        return sb.toString();
    }
}
