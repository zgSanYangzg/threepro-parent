package cn.three.module.ribbon.service;

import cn.three.module.ribbon.bo.User;
import cn.three.module.ribbon.command.UserCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * //没通过
 * Created by Administrator on 2017/11/17 0017.
 */
@Service
public class UserService {

    public User sayUser(){

        return new UserCommand(new RestTemplate(),1L).execute();

    }
}
