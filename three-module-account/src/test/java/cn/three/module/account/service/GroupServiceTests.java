package cn.three.module.account.service;

import cn.three.module.account.pojo.model.CAccountModel;
import cn.three.module.account.pojo.model.GroupInfoModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/2/3.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupServiceTests {
    @Autowired
    private GroupService service;

    @Test
    public void groupTest() {
        try {
            GroupInfoModel model = new GroupInfoModel();
            model.setCompanyId("company20100909zijmxn7qze0000000750");
            model.setGroupName("主组");
            model.setGroupSn("010101");
            model.setRoleId("role000000001");

            model.setAccountId("accountid12313223132132");
            model.setGroupInfoId("groupid456456456456456");

            model = service.saveGroupInfo(model);
            System.out.println("saveGroupInfo:  " + model.toString());
            System.out.println("findGroupInfo:  " + service.findGroupInfo(model.getGroupInfoKey()).toString());
            model.setGroupName("edit主组");
            model = service.editGroupInfo(model);
            System.out.println("editGroupInfo:  " + model.toString());
            service.allotRole(model.getCompanyId(), model.getGroupInfoId(), new String[]{"role000000001", "role000000002"});
            System.out.println("succ  allotRole");
            System.out.println("findGroupBy:  " + service.findGroupBy(model.getAccountId()).toString());
            CAccountModel acctmodel = service.findGroupRoleBy(model.getCompanyId(), model.getGroupInfoId());
            System.out.println("findGroupRoleBy:  " + acctmodel.getRoleIds());

            service.delGroupInfo(model.getGroupInfoKey());
            System.out.println("succ  delGroupInfo" + model.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
