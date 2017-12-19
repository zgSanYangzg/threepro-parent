package cn.three.module.ribbon.service;

import cn.three.module.ribbon.bo.User;
import org.springframework.stereotype.Service;

/**
 * //没通过
 * Created by Administrator on 2017/11/17 0017.
 */
@Service
public class UserService {

    public User sayUser(){

        return null;
        /*return new UserCommand(new RestTemplate(),1L).execute();*/

    }
}
