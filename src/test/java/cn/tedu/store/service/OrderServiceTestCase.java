package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;

/**
 * 业务测试类:可以不使用接口作为bean,直接使用接口类
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestCase {

	@Autowired
	private IOrderService service;
	@Autowired
	private IAddressService service2;
	/**
	 * 业务测试:增加订单数据
	 */
	@Test
	public void order() {
		try {
			Integer[] cids = {1,33};
			Integer aid = 15;
			String username = "root";
			Integer uid = 1;
			Order order = service.create(cids, aid, username, uid);
			System.err.println(order);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
	@Test
	public void x() {
		try {
			Address address = service2.getByAid(19);
			System.err.println(address);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
}








