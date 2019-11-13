package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

public interface OrderMapper {
	/**
	 * 增加订单详情
	 * @return 结果
	 */
	Integer insertOrder(Order order);
	
	/**
	 * 增加订单商品详情
	 * @return 结果
	 */
	Integer insertOrderItem(OrderItem orderItem);
}
