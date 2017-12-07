package cn.three.module.ribbon.controller;

import cn.three.module.ribbon.bo.User;
import cn.three.module.ribbon.service.HelloService;
import cn.three.module.ribbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * 注解方式测试通过
 * Created by Administrator on 2017/11/1 0001.
 */
@RestController
public class ConsumerController {

//    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    HelloService helloService;
    @Autowired
    UserService us;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){

        //return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
        return helloService.helloService();
    }

    @RequestMapping(value = "/ribbon-user",method = RequestMethod.GET)
    public User userConsumer() throws Exception{
        User u=null;
//        User u = us.sayUser();
//        System.out.print(u.getAge());//没通过
        Future<User> fu = helloService.getUserByIdAsync(1L);
        u=fu.get();
        System.out.print("------------------"+u.getAge());
        return u;
    }
}
