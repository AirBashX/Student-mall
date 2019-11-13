package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

/**
 * 测试类:mapping持久层测试类
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {

	@Autowired
	public UserMapper mapper;
	
	/**
	 * 测试添加数据是否成功
	 */
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("root");
		user.setPassword("1234");
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
	}
	
	/**
	 *测试查找数据是否成功
	 */
	@Test
	public void findByUsername() {
		User user = mapper.findByUsername("root");
		System.err.println(user);
	}
	
	/**
	 * 测试修改数据是否成功
	 */
	@Test
	public void updatePassword(){
		Date date = new Date();
		Integer insert = mapper.updatePassword(9, "1234","root", date);
		System.err.println(insert);
	}
	
	/**
	 * 测试验证密码是否成功
	 */
	@Test
	public void findByUid(){
		User user = mapper.findByUid(9);
		System.err.println(user.getPassword());
		System.err.println(user.getSalt());
	}
	
	/**
	 * 测试修改资料是否成功
	 */
	@Test
	public void updateInfo(){
		User user = new User();
		user.setUid(1);
		user.setEmail("1");
		user.setPhone("1");
		user.setGender(0);
		user.setModifiedUser("root");
		Date date = new Date();
		user.setModifiedTime(date);
		Integer rows = mapper.updateInfo(user);
		System.err.println(rows);
	}
	
	/**
	 * 测试上传头像是否成功
	 */
	@Test
	public void updateAvatar(){
		Integer uid=1;
		String avatar="x";
		String modifiedUser="超级用户";
		Date date = new Date();
		Date  modifiedTime=date;
		Integer rows = mapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
		System.out.println(rows);
	}
}









