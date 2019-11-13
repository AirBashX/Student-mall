package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Goods;

/**
 * 业务测试类:Goods
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTestCase {
	@Autowired
	public IGoodsService service;
	
	/**
	 * 业务类测试方法:查看热门商品
	 */
	@Test
	public void getHostList() {
		List<Goods> list = service.getHostList();
		for(Goods goods : list) {
			System.err.println(goods.getImage());
		}
	}
	
	/**
	 * 业务测试方法:查看商品排行
	 */
	@Test
	public void getById() {
		Goods goods = service.getById(10000001l);
		System.err.println(goods.getImage());
	}
}









