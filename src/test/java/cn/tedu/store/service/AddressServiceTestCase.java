package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

/**
 * 业务测试类:可以不使用接口作为bean,直接使用接口类
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTestCase {

	@Autowired
	private IAddressService service;
	/**
	 * 业务测试:增加地址
	 */
	@Test
	public void addNew(){
		try {
			Address address = new Address();
			address.setUid(2);
			address.setName("tom");
			String username="root";
			service.addnew(address, username);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	/**
	 * 业务测试:查看地址列表
	 */
	@Test
	public void findByUid(){
		List<Address> list = service.getByUid(1);
		for(Address address:list){
			System.err.println(address);
		}
	}
	/**
	 * 业务测试:修改为默认
	 */
	@Test
	public void setDefault() {
		try {
			Integer uid =1;
			Integer aid= 12;
			String username="zsp";
			service.setDefalut(uid, aid, username);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	/**
	 * 业务测试:删除收货地址
	 */
	@Test
	public void delete() {
		try {
			Integer uid = 1;
			Integer aid = 12;
			String username = "root";
			service.delete(uid, aid, username);
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
			
		}
	}
}








