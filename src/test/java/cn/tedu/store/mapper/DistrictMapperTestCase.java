package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

/**
 * 持久层测试类:DistrictMapper.xml
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTestCase {

	@Autowired
	DistrictMapper mapper;
	
	/**
	 * 持久层测试:查询地址列表
	 */
	@Test
	public void findByParent(){
		List<District> list = mapper.findByParent("86");
		for(District districrt:list){
			System.err.println(districrt);
		}
		System.err.println(1);
	}
	
	/**
	 * 持久层测试:查询省市区名称
	 */
	@Test
	public void findByCode(){
		District data = mapper.findByCode("110000");
		System.err.println(data);
	}
	
}









