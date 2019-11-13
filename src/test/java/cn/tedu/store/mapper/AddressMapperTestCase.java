package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

/**
 * 持久层测试类:AddressMapper.xml
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTestCase {

	@Autowired
	public AddressMapper mapper;
	
	/**
	 * 持久层测试:查询地址条数
	 */
	@Test
	public void countByUid(){
		Integer rows = mapper.countByUid(1);
		System.err.println(rows);
	}
	/**
	 * 持久层测试:增加地址
	 */
	@Test
	public void insert(){
		Address address = new Address();
		address.setAid(1);
		address.setName("root");
		address.setProvince("山东省");
		address.setCity("烟台市");
		address.setArea("芝罘区");
		address.setDistrict("山东省烟台市芝罘区");
		address.setZip("400000");
		address.setAddress("达内教育");
		address.setTel("123456789");
		address.setPhone("123456789");
		Integer rows = mapper.insert(address);
		System.out.println(rows);
	}
	/**
	 * 持久层测试:显示收货地址列表
	 */
	@Test
	public void findByUid(){
		List<Address> list = mapper.findByUid(1);
		for(Address address : list){
			System.err.println(address);	
		}
	}
	
	/**
	 * 持久层测试:修改默认地址前,查看地址是否存在
	 */
	@Test
	public void findByAid() {
		Address result = mapper.findByAid(12);
		System.err.println(result);
	}
	/**
	 * 持久层测试:修改默认地址前,将所有地址设为非默认地址
	 */
	@Test
	public void updateNoDefault() {
		Integer rows = mapper.updateNoDefault(1);
		System.err.println(rows);
	}
	/**
	 * 持久层测试:修改为默认地址
	 */
	@Test
	public void updateDefault() {
		Date date =new Date();
		Integer rows = mapper.updateDefault(1, "root", date);
		System.err.println(rows);
	}
	
	/**
	 * 持久层测试:删除收货地址
	 */
	@Test
	public void deleteDefault() {
		Integer rows = mapper.deleteByAid(11);
		System.err.println(rows);
	}
}









