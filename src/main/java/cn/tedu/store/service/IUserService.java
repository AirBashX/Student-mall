package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

/**
 * 业务层接口
 * 继承此类的类必须抛出两个异常
 * @author ZSP
 *
 */
public interface IUserService {
	/**
	 * 用户注册
	 * @param user 将要注册的用户数据
	 * @throws UsernameDuplicateException
	 * @throws InsertException
	 */
	void reg(User user) throws UsernameDuplicateException,InsertException;
	
	/**
	 * 用户登录
	 * @param username 用户登录时输入的用户名
	 * @param password 用户登录时输入的密码
	 * @return	User类型
	 * @throws UserNotFoundException 用户名错误
	 * @throws PasswordNotMatchException 密码错误
	 */
	User login(String username,String password) throws UserNotFoundException,PasswordNotMatchException;
	
	/**
	 * 修改密码
	 * @param uid 用户ID
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @param username 用户名
	 */
	void changePassword(Integer uid,String oldPassword,String newPassword,String username) throws PasswordNotMatchException,UserNotFoundException,UpdateException;
	
	/**
	 * 修改数据
	 * @param user 用户新数据+session中uid
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeInfo(User user) throws UserNotFoundException,UpdateException;
	
	/**
	 * 修改数据前查看数据
	 * @param uid session中uid
	 * @return User
	 * @throws UserNotFoundException
	 */
	User getByUid(Integer uid) throws UserNotFoundException;

	/**
	 * 上传头像
	 * @param uid session中uid
	 * @param avatar 上传头像的服务器地址 
	 * @param modifiedUser 修改者
	 * @throws UserNotFoundException 
	 * @throws UpdateException
	 */
	void changeAvatar(Integer uid,String avatar,String modifiedUser) throws UserNotFoundException,UpdateException;
}
