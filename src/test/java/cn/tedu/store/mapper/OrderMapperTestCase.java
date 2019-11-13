package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * 持久层测试类:CastMapper.xml
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestCase {

	@Autowired
	public CartMapper mapper;
	
	/**
	 * 持久层测试方法:增加购物车记录
	 */
	@Test
	public void insert() {
		Date date = new Date();
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setGid(10000001L);
		cart.setCreatedUser("root");
		cart.setCreatedTime(date);
		cart.setModifiedUser("root");
		cart.setModifiedTime(date);
		Integer rows = mapper.insert(cart);
		System.err.println(rows);
	}
	
	/**
	 * 持久层测试方法:修改购物车记录
	 */
	@Test
	public void update() {
		Integer cid =1;
		Date date = new Date();
		Date modifiedTime = date;
		String modifiedUser = "root";
		Integer num = 1;
		Integer rows = mapper.update(num, cid, modifiedTime, modifiedUser);
		System.err.println(rows);
	}
	
	/**
	 * 持久层测试方法:查看情况
	 */
	@Test
	public void select() {
		Cart cart = mapper.select(1, 10000001L);
		System.err.println(cart);
	}
	
	/**
	 * 持久层测试方法:查看购物车列表
	 */
	@Test
	public void findByUid() {
		List<CartVO> list = mapper.findByUid(1);
		System.err.println("begin");
		for(CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}
	
	/**
	 * 持久层测试方法:根据Cid测试数据是否来自同一用户
	 */
	@Test
	public void findByCid() {
		Cart cart = mapper.findByCid(1);
		System.err.println(cart);
	}
	
	/**
	 * 持久层测试方法:根据cid查询添加要结算的商品
	 */
	@Test
	public void findByCids() { 
		Integer[] cid = new Integer[] {1,33};
		List<CartVO> list = mapper.findByCids(cid);
		for(CartVO cart : list) {
			System.err.println(cart);
		} 
	}
	 
}
