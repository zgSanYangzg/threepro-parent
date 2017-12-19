package cn.three.core.database.dao;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
public class BaseRepositoryImpl<T,ID extends Serializable>
        extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager=em;
    }
    public List<Object[]> listBySQL(String sql) {
        return entityManager.createNativeQuery(sql).getResultList();
    }

    public void updateBySql(String sql,Object...args) {
        Query query = entityManager.createNativeQuery(sql);
        int i = 0;
        for(Object arg:args) {
            query.setParameter(++i,arg);
        }
        query.executeUpdate();
    }

    public void updateByHql(String hql,Object...args) {
        Query query = entityManager.createQuery(hql);
        int i = 0;
        for(Object arg:args) {
            query.setParameter(++i,arg);
        }
        query.executeUpdate();
    }
}
