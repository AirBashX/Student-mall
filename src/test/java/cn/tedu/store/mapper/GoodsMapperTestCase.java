package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Goods;


/**
 * 持久层测试类:GoodsMapper.xml
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTestCase {
	@Autowired
	GoodsMapper mapper;
	
	/**
	 * Goods测试类:查看热门排行榜商品
	 */
	@Test
	public void findHostList() {
		List<Goods> list = mapper.findHostList();
		for(Goods goods : list) {
			System.err.println(goods.getImage());
		}
	}
	
	/**
	 * Goods测试方法:查看商品详情
	 */
	@Test
	public void findByList() {
		Goods goods = mapper.findById(10000001L);
		System.err.println(goods.getImage());
	}
	
}









