package cn.three.core.database.dao;

import cn.three.core.database.base.JpCar;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
public interface StaffRepository extends BaseRepository<JpCar,String>,JpaSpecificationExecutor<JpCar>{


}
