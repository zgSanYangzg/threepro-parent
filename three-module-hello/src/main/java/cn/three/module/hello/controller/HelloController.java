package cn.three.module.hello.controller;

import cn.three.module.hello.bo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@RestController
public class HelloController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${book.dec}")
    private String info;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){

        User u = new User();
        u.setId(id);
        u.setAge(2222);
        return u;

    }

    @RequestMapping("/hello")
    public String index() throws Exception{
        System.out.print(info);
        List<ServiceInstance> list = client.getInstances("hello-service");//
        System.out.println(client.getLocalServiceInstance());//
        System.out.println("client.getServices().size() = " + client.getServices().size());

        for( String s :  client.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  client.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

        System.out.println(list.size());//
        if (list != null && list.size() > 0 ) {
            System.out.println( list.get(0).getUri()  );
        }

        int sleeptime= new Random().nextInt( 3000);
        log.info("time---"+sleeptime);
        Thread.sleep(sleeptime);

        return "Hello";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){

        return "Hello "+name;
    }
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name ,@RequestHeader Integer age){
        return new User(1L,name,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello "+user.getName()+", "+user.getAge();
    }
}
