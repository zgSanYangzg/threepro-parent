package cn.three.module.account.service;

import cn.three.module.security.model.CRoleModel;
import cn.three.module.security.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTests {
    @Autowired
    private RoleService roleService;

    @Test
    public void findRoleByTest() {
        String companyId = "company201009046vxdyzy4wg0000000025";
        try {
            List<CRoleModel> lst = roleService.findRoleBy(companyId,"");
            for (CRoleModel m : lst) {
                System.out.println(m.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void roleTest(){
        CRoleModel model=new CRoleModel();
        model.setCompanyID("company201009046vxdyzy4wg0000000025");
        model.setRoleDesc("test描述");
        model.setRoleName("test角色");
        model.setCompanyName("test公司");
        model.setOpostName("test岗位名称");
        model.setOrganizationName("test机构名称");
        model.setOrganizationNameDesc("test机构描述");
        try {
            model=roleService.saveRole(model);
            System.out.print(model.toString());
            model.setRoleDesc("edit描述");
            model=roleService.editRole(model);
            System.out.print(model.toString());
            roleService.delRole(model.getRoleKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
