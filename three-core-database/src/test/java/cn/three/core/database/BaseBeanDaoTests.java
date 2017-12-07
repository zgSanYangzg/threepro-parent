package cn.three.core.database;

import cn.three.core.database.base.JpCar;
import cn.three.core.database.dao.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseBeanDaoTests {

    @Autowired
    StaffRepository dao;

    @Test
    public void humanTest(){

        JpCar c = new JpCar();
        c.setCarKey(UUID.randomUUID().toString());
        c.setCarId(UUID.randomUUID().toString());
        dao.save(c);

       List<JpCar> beans= dao.findAll();

       System.out.print(beans.size());
    }
}
