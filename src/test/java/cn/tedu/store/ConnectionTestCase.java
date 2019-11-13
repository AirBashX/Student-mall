package cn.tedu.store;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类,验证连接数据库能否连接
 * @author ZSP
 *
 */
@RunWith(SpringRunner.class)//加载Spring文件
@SpringBootTest
public class ConnectionTestCase {
	
	@Autowired
	public DataSource dataSource;
	@Test
	public void getConnection() {
		try {
			Connection conn = dataSource.getConnection();
			System.err.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
