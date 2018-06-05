package cn.three.module.account.dao;

import cn.three.core.database.dao.GenericDAOImpl;
import cn.three.module.account.pojo.GroupInfo;
import cn.three.module.account.pojo.GroupRole;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/2.
 */
@Repository(value = "groupInfoDao")
public class GroupInfoDaoImpl extends GenericDAOImpl<GroupInfo> implements GroupInfoDao {


    @Override
    public List<GroupRole> findRoleBy(String groupId) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("GROUPID", groupId);
        return this.findObjects("SELECT * FROM DT_GROUP_ROLE WHERE GROUPID = :GROUPID", parameters);
    }

    /**
     * 根据用户查询用户组
     *
     * @param accountId
     * @return 用户组的id
     * @throws Exception
     */
    @Override
    public List<String> findGroupBy(String accountId) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ACCOUNTID", accountId);
        return this.findObjects("SELECT GROUPID FROM DTACCOUNTGROUP WHERE ACCOUNTID=:ACCOUNTID", parameters);
    }

    @Override
    public List<Map<String, String>> findGroupInfo(List<String> groupids) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT T.GROUPINFOID GROUPID,T.GROUPNAME GROUPNAME FROM ");
        sql.append(this.tableName());
        sql.append(" T WHERE T.GROUPINFOID IN(");
        for (int i = 0; i < groupids.size(); i++) {
            sql.append("?,");
        }
        sql.deleteCharAt(sql.length() - 1).append(")");
        System.out.print(sql.toString());
        Query query = this.getEntityManager().createNativeQuery(sql.toString());

        for (int i = 0; i < groupids.size(); i++) {
            query.setParameter(i+1, groupids.get(i));
        }

        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();

    }
}
