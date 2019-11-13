package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * 业务测试类:可以不使用接口作为bean,直接使用接口类
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTestCase {

	@Autowired
	private ICartService service;
	
	/**
	 * 业务测试方法:添加到购物车中
	 */
	@Test
	public void cartt() {
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGid(10000001L);
		service.addCart(cart, "root");
	}
	
	/**
	 * 业务测试方法:显示购物车列表
	 */
	@Test
	public void getByUid() {
		List<CartVO> list = service.getByUid(1);
		System.err.println("begin");
		for(CartVO cart: list) {
			System.err.println(cart);
		}
	}
	
	/**
	 * 业务测试方法:添加购物车列表的商品数量
	 */
	@Test
	public void addNum() {
		Integer num = service.addNum(1, 1, "root");
		System.err.println(num);
	}
	
	/**
	 * 业务测试方法:显示下单的购物车数据
	 */
	@Test
	public void getByCids() {
		Integer[] cid = new Integer[] {1,33};
		List<CartVO> cids = service.getByCids(cid);
		for(CartVO cart : cids) {
			System.err.println(cart);
		}	
	}
}








