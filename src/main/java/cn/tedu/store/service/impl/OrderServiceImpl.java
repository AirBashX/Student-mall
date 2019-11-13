package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVO;

/**
 * 业务类:订单数据
 * @author ZSP
 */
@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private IAddressService addressService;
	@Autowired
	private ICartService CartService;

	@Override
	@Transactional
	public Order create(Integer[] cids,Integer aid,String username,Integer uid) throws InsertException{
		Date date = new Date();
		Address address = addressService.getByAid(aid);
		List<CartVO> list = CartService.getByCids(cids);
		Long totalPrice = 0L;
		for(CartVO cartVO : list) {
			Integer num = cartVO.getNum();
			Long price = cartVO.getPrice();
			totalPrice = totalPrice+num*price;
		}
		Order order = new Order();
		order.setUid(uid);
		order.setRecvName(address.getName());
		order.setRecvAddress(address.getDistrict()+address.getAddress());
		order.setRecvPhone(address.getPhone());
		order.setTotalPrice(totalPrice);
		order.setStatus(0);
		order.setOrderTime(date);
		order.setCreatedTime(date);
		order.setModifiedTime(date);
		order.setCreatedUser(username);
		order.setModifiedUser(username);
		InsertOrder(order);
		for(CartVO cartVO : list) {
			OrderItem item = new OrderItem();
			item.setGid(cartVO.getGid());
			item.setOid(order.getOid());
			item.setGoodsImage(cartVO.getImage());
			item.setGoodsNum(cartVO.getNum());
			item.setGoodsPrice(cartVO.getPrice());
			item.setGoodsTitle(cartVO.getTitle());
			item.setCreatedUser(username);
			item.setCreatedTime(date);
			item.setModifiedUser(username);
			item.setModifiedTime(date);
			InsertOrderItem(item);
		}
		return order;
		
	}
	/**
	 * 添加订单数据
	 * @param order
	 */
	public void InsertOrder(Order order) {
		Integer rows = orderMapper.insertOrder(order);
		if(rows != 1) {
			throw new InsertException();
		}
	}
	/**
	 * 添加订单商品数据
	 * @param item
	 */
	public void InsertOrderItem(OrderItem item) {
		Integer rows = orderMapper.insertOrderItem(item);
		if(rows != 1) {
			throw new InsertException();
		}
	}
}
