package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的持久层接口
 * @author ZSP
 */
public interface UserMapper {
	
	/**
	 * 插入用户的数据
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer insert(User user);
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据,没有数据返回null
	 */
	User findByUsername(String username);
	
	/**
	 * 根据UID修改用户密码
	 * @param uid 用户名
	 * @param password 密码
	 * @param modifiedUser 最后修改者
	 * @param modifiedTime 最后修改时间
	 * @return 是否成功
	 */
	Integer updatePassword(
			@Param("uid") Integer uid,
			@Param("password") String password,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime
	);
	
	/**
	 * 根据UID查看用户密码和盐值
	 * @param uid
	 * @return User 
	 */
	User findByUid(Integer uid);
	
	/**
	 * 根据UID修改用户数据
	 * @param user
	 * @return Integer 是否成功
	 */
	Integer updateInfo(User user);
	
	/**
	 * 
	 * @param uid session中的uid
	 * @param avatar 上传的用户头像服务器地址
	 * @param midifiedUser 修改者
	 * @param modifiedTime 修改时间
	 */
	Integer updateAvatar(@Param("uid") Integer uid,@Param("avatar") String avatar,@Param("modifiedUser") String modifiedUser,@Param("modifiedTime") Date modifiedTime);
	
}
