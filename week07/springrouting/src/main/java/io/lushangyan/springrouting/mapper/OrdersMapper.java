package io.lushangyan.springrouting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lushangyan.springrouting.datasource.CurDataSource;
import io.lushangyan.springrouting.datasource.DataSourceNames;
import io.lushangyan.springrouting.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author lushangyan
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    Orders findOrder(int id);

    @CurDataSource(name = DataSourceNames.DB1)
    Orders findOrderAnnotation(int id);

    int insertOrder(@Param("orders") Orders orders);

    @CurDataSource(name = DataSourceNames.DB1)
    int insertOrderAnnotation(@Param("orders") Orders orders);

}
