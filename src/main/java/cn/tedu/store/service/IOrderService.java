package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
import cn.tedu.store.service.ex.InsertException;

public interface IOrderService {
	
	/**
	 * 添加订单/商品数据
	 * @param order 订单信息
	 * @param item 订单商品信息
	 */
	Order create(Integer[] cids,Integer aid,String username,Integer uid) throws InsertException;
}
