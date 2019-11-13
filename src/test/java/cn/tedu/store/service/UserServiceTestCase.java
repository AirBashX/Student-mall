package cn.tedu.store.service;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;
/**
 * 业务测试类:可以不使用接口作为bean,直接使用接口类
 * @author ZSP
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {

	@Autowired
/*	public UserServiceImpl service;*/
	public IUserService service;
	@Test
	public void reg(){
		try {
			User user = new User();
			user.setUsername("roots");
			user.setPassword("1234");
			service.reg(user);
			System.err.println("ok .");
		} catch (ServiceException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void login(){
		try {
			String username ="service";
			String password = "1234";
			service.login(username, password);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
	@Test
	public void x(){
		String password="1234";
		String salt = UUID.randomUUID().toString().toUpperCase();
		String str = salt+password+salt;
		for(int i=0;i<5;i++){
			str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		System.err.println(salt);
		System.err.println(str);
	}
	
	/**
	 * 业务类测试:修改密码
	 */
	@Test
	public void updatePassword(){
		try {
			service.changePassword(8, "1234","4567","Abc");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
	/**
	 * 业务测试:修改数据
	 */
	@Test
	public void updateInfo(){
		try {
			User user =new User();
			user.setUid(2);
			user.setPhone("2");
			user.setEmail("2");
			user.setGender(0);
			user.setModifiedUser("1");
			Date date = new Date();
			user.setModifiedTime(date);
			service.changeInfo(user);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
	}
	
	/**
	 * 业务测试:上传头像
	 */
	@Test
	public void changeAvater(){
		try {
			Integer uid=100;
			String avatar ="123";
			String modifiedUser="123";
			service.changeAvatar(uid, avatar, modifiedUser);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getClass());
		}
		
		
	}
}








