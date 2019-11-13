package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;
import cn.tedu.store.service.ex.ServiceException;

/**
 * 业务测试类:可以不使用接口作为bean,直接使用接口类
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTestCase {

	@Autowired
	private IDistrictService service;
	/**
	 * 业务测试:查看省市区列表
	 */
	@Test
	public void getByParent(){
		try {
			List<District> list = service.getByParent("86");
			for(District district:list){
				System.err.println(district);
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	/**
	 * 业务测试:根据地址编号获取地址
	 */
	@Test
	public void getByCode(){
		String code ="110000";
		District data = service.getBycode(code);
		System.err.println(data);
	}
	
	
}








