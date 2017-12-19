package cn.three.core.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
@NoRepositoryBean
@Transactional(readOnly=true)
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    /*List<Object[]> listBySQL(String sql);

    @Transactional
    public void updateBySql(String sql,Object...args);
    @Transactional
    public void updateByHql(String hql,Object...args);*/
}
