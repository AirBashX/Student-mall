package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
/**
 * 业务类
 * 处理注册/登录/修改流程
 * @author ZSP
 * @see IUserService
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 业务:注册
	 */
	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {
		//根据尝试注册的用户名查询数据
		User result = userMapper.findByUsername(user.getUsername());
		if(result == null){//是:允许注册
			//添加表单上隐藏的数据:isDelete/日志
			user.setIsDelete(0);
			Date now = new Date();
			user.setCreatedUser(user.getUsername());
			user.setCreatedTime(now);
			user.setModifiedUser(user.getUsername());
			user.setModifiedTime(now);
			//添加接受到的表单信息
			//生成大写随机盐
			String salt = UUID.randomUUID().toString().toUpperCase();
			String md5Password = getMd5Password(user.getPassword(), salt);
			user.setSalt(salt);
			user.setPassword(md5Password);
			Integer rows = userMapper.insert(user);
			if(rows !=1){
				throw new InsertException("注册时发生未知错误,请联系管理员!");
			}
		}else{
			throw new UsernameDuplicateException("尝试注册的用户名("+user.getUsername()+"已经被占用)");
		}
	}
	
	/**
	 * 业务:登录
	 */
	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		User result = userMapper.findByUsername(username);
		if(result == null){//判断用户名是否存在,null为不存在
			throw new UserNotFoundException("登录失败用户名不存在");
		}
		if(result.getIsDelete()==1){//判断用户是否已删除,1为删除
			throw new UserNotFoundException("登录失败用户名不存在");
		}
		String salt = result.getSalt();
		String md5Password = getMd5Password(password, salt);//得到输入密码的MD5值
		if(!result.getPassword().equals(md5Password)){//判断输入密码是否与数据库密码一致
			throw new PasswordNotMatchException("登录失败密码错误");
		}
		//把关键属性设置为0,若走到这一步说明用户登录成功
		result.setSalt(null);
		result.setPassword(null);
		result.setIsDelete(null);
		return result;
	}
	
	/**
	 * 业务:修改密码
	 */
	@Override
	public void changePassword(Integer uid, String oldPassword, String newPassword, String username) throws PasswordNotMatchException,UserNotFoundException,UpdateException{
		User user = userMapper.findByUid(uid);
		if(user==null){//判断是否存在该用户:出现错误查询不到:null不存在
			throw new UserNotFoundException("修改密码失败,尝试访问的用户数据不存在");
		}
		if(user.getIsDelete()==1){//判断是否存在该用户:可能登陆后管理员删除该账户:1删除
			throw new UserNotFoundException("修改密码失败,尝试访问的用户数据不存在");
		}
		String salt =user.getSalt();
		String md5Password = getMd5Password(oldPassword, salt);
		if(!user.getPassword().equals(md5Password)){//判断密码是否正确
			throw new PasswordNotMatchException("修改密码失败,原密码错误!");
		}
		Date modifiedTime = new Date();
		newPassword = getMd5Password(newPassword, salt);
		//执行修改
		Integer rows = userMapper.updatePassword(uid, newPassword, user.getUsername(), modifiedTime);
		if(rows==null){
			throw new UpdateException("修改密码错误!更新数据发生未知错误");
		}	
	}
	/**
	 * 业务:修改数据
	 */
	@Override
	public void changeInfo(User user) throws UserNotFoundException,UpdateException{
		Integer uid = user.getUid();
		User result = userMapper.findByUid(uid);
		if(result==null){//判断是否存在该用户:出现错误查询不到:null不存在
			throw new UserNotFoundException("更新数据失败,尝试访问的用户数据不存在");
		}
		if(result.getIsDelete()==1){//判断是否存在该用户:可能登陆后管理员删除该账户:1删除
			throw new UserNotFoundException("更新数据失败,尝试访问的用户数据不存在");
		}
		Integer rows = userMapper.updateInfo(user);
		if(rows!=1){
			throw new UpdateException("更新数据错误!跟新数据发生未知错误");
		}
	}
	/**
	 * 业务:修改数据前查看数据
	 */
	@Override
	public User getByUid(Integer uid) throws UserNotFoundException {
		User result = userMapper.findByUid(uid);
		if(result==null){//判断是否存在该用户:出现错误查询不到:null不存在
			throw new UserNotFoundException("获取数据失败,尝试访问的用户数据不存在");
		}
		if(result.getIsDelete()==1){//判断是否存在该用户:可能登陆后管理员删除该账户:1删除
			throw new UserNotFoundException("获取数据失败,尝试访问的用户数据不存在");
		}
		result.setPassword(null);
		result.setSalt(null);
		result.setIsDelete(null);
		return result;
	}
	/**
	 * 业务:上传头像
	 */
	@Override
	public void changeAvatar(Integer uid, String avatar, String modifiedUser)
			throws UserNotFoundException, UpdateException {
		User result = userMapper.findByUid(uid);
		if(result==null){//判断是否存在该用户:出现错误查询不到:null不存在
			throw new UserNotFoundException("上传失败,尝试访问的用户数据不存在");
		}
		if(result.getIsDelete()==1){//判断是否存在该用户:可能登陆后管理员删除该账户:1删除
			throw new UserNotFoundException("上传失败,尝试访问的用户数据不存在");
		}
		Date modifiedTime = new Date();
		Integer rows = userMapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
		if(rows!=1){
			throw new UpdateException("更新数据错误!跟新数据发生未知错误");
		}
	}
	
	/**
	 * 注册时:密码加密
	 * @param password 密码
	 * @param salt 盐值,防止与网上的MD5网站比较
	 * @return 加密后的大写32位结果
	 */
	private String getMd5Password(String password,String salt){
		String str =salt + password +salt;
		for(int i=0;i<5;i++){
			str = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		return str;
	}
}
