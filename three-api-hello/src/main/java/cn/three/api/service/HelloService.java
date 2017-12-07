package cn.three.api.service;

import cn.three.api.bo.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@RequestMapping("/refactor")
public interface HelloService {
    @RequestMapping(value = "/hello4",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);
    @RequestMapping(value = "/hello5",method = RequestMethod.GET)
    public User hello(@RequestHeader("name") String name , @RequestHeader("age") Integer age);
    @RequestMapping(value = "/hello6",method = RequestMethod.POST)
    public String hello(@RequestBody User user);
}
