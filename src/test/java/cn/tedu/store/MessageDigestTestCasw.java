package cn.tedu.store;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*import org.springframework.util.DigestUtils;*/

/**
 * 测试类,使用MD5/UUID校验
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDigestTestCasw {
	
	/**
	 * md5校验测试
	 */
/*	@Test
	public void md5(){
		String password = "123456";
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
		System.out.println(md5DigestAsHex);
	}*/
	
	/**
	 * 额外摘要测试
	 */
	@Test
	public void otherDigest(){
		String password = "123456";
		String md5DigestAsHex = DigestUtils.md5Hex(password);
		System.out.println(md5DigestAsHex);
	}


	/**
	 * UUID测试
	 */
	@Test
	public void uuid(){
		String uid = UUID.randomUUID().toString().toUpperCase();
		System.err.println(uid);
	}
}
