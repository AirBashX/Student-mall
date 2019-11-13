package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/**
 * 持久层测试类:CastMapper.xml
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTestCase {
	
	@Autowired
	private OrderMapper mapper;
	
	@Test
	public void InsertOrder() {
		Order order = new Order();
		Date date = new Date();
		order.setUid(1);
		order.setRecvName("root");
		order.setRecvPhone("123456789");
		order.setRecvAddress("yantai");
		order.setTotalPrice(1000L);
		order.setStatus(1);
		order.setOrderTime(date);
		order.setPayTime(date);
		order.setCreatedUser("root");
		order.setCreatedTime(date);
		Integer rows = mapper.insertOrder(order);
		System.err.println(rows);
	}
	
	@Test
	public void InsertOrderItem() {
		OrderItem item = new OrderItem();
		Date date = new Date();
		item.setOid(1);
		item.setGid(10000001L);
		item.setGoodsTitle("123");
		item.setGoodsImage("456");
		item.setGoodsPrice(1000L);
		item.setGoodsNum(12);
		item.setCreatedUser("root");
		item.setCreatedTime(date);
		Integer rows = mapper.insertOrderItem(item);
		System.err.println(rows);
	}
}
