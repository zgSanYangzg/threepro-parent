package cn.three.module.ribbon.service;

import cn.three.module.ribbon.bo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //,ignoreExceptions = {NullPointerException.class} 某些异常不做异常处理
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String helloService(){

        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }

    //默认同步,参数中{0} 命令名称 {1} 分组 {2} 线程池划分
    @HystrixCommand(commandKey = "getUserById",groupKey = "UserGroup",threadPoolKey = "getUserByIdThread")
    public User getUserById(Long id){
        return restTemplate.getForObject("http://hello-service/user/{1}",User.class,id);
    }
    //异步
    @HystrixCommand(commandKey = "getUserById",groupKey = "UserGroup",threadPoolKey = "getUserByIdThread")
    public Future<User> getUserByIdAsync(final Long id){

        return new AsyncResult<User>(){
            public User invoke(){
                return restTemplate.getForObject("http://hello-service/user/{1}",User.class,id);
            }
        };
}


    @HystrixCommand(fallbackMethod = "secFallBack")
    public String helloFallBack(){
//此处可能是另外一个
        return "error";
    }
    public String secFallBack(){

        return "error";
    }
}
