package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.FileEmptyException;
import cn.tedu.store.service.ex.FileIOException;
import cn.tedu.store.service.ex.FileSizeException;
import cn.tedu.store.service.ex.FileStateException;
import cn.tedu.store.service.ex.FileTypeException;
import cn.tedu.store.util.ResponseResult;

/**
 * 用户控制类:用于执行登录\注册功能
 * @author ZSP
 * @see BaseController
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
	@Autowired
	private IUserService userService;
	
	/**
	 * 用户注册
	 * @param form表单注册信息
	 * @return 处理结果[\数据]
	 */
	@PostMapping("reg")
	public ResponseResult<Void> reg(User user){
		/*try {*/
			//执行注册
			userService.reg(user);
			//执行成功
			return new ResponseResult<>(SUCCESS);
		/*} catch (UsernameDuplicateException e) {
			return new ResponseResult<>(2, e.getMessage());
		}catch(InsertException e){
			return new ResponseResult<>(3, e.getMessage());
		}*/
	}
	
	/**
	 * 用户登录
	 * @param username form表单用户名
	 * @param password form表单密码
	 * @param session 添加uid/username
	 * @return 处理结果代码[\数据]
	 */
	@PostMapping("login")
	public ResponseResult<User> login(String username,String password,HttpSession session){
		//执行登录
		User result = userService.login(username, password);
		session.setAttribute("uid",result.getUid());
		session.setAttribute("username", result.getUsername());
		//添加Session
		return new ResponseResult<User>(SUCCESS,result);
	}
	
	/**
	 * 修改密码
	 * @param oldPassword 用户输入原始密码
	 * @param newPassword 用户输入新密码
	 * @param session username
	 * @return
	 */
	@PostMapping("change_password")
	public ResponseResult<Void> changePassword(@RequestParam("old_password") String oldPassword,
			@RequestParam("new_password") String newPassword,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		userService.changePassword(uid, oldPassword, newPassword, username);
		return new ResponseResult<>(SUCCESS);
	}
	
	/**
	 * 修改用户数据
	 * @param user 用户输入新数据
	 * @param session uid username
	 * @return 处理结果
	 */
	@PostMapping("change_info")
	public ResponseResult<Void> changeInfo(User user,HttpSession session){
		//从session中获取数据
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		//将session数据添加到User对象中
		user.setUid(uid);
		user.setUsername(username);
		user.setModifiedUser(username);
		//将时间放入user中
		Date date = new Date();
		user.setModifiedTime(date);
		userService.changeInfo(user);
		return new ResponseResult<>(SUCCESS);
	}
	/**
	 * 修改数据前查看数据
	 * @param session 获取session
	 * @return 处理结果和数据
	 */
	@PostMapping("details")
	public ResponseResult<User> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		User data = userService.getByUid(uid);
		return new ResponseResult<>(SUCCESS,data);
	}
	/**
	 * 上传头像的服务器路径
	 */
	public static final String UPLOAD_DIR ="upload";
	/**
	 * 上传头像的最大值
	 */
	public static final long UPLOAD_AVATAR_MAX_SIZE=1*1024*1024;
	/**
	 * 上传头像的文件类型
	 */
	public static final List<String> UPLOAD_AVATAR_TYPES = new ArrayList<>();
	static{
		UPLOAD_AVATAR_TYPES.add("image/jpeg");
		UPLOAD_AVATAR_TYPES.add("image/png");
	}
	
	/**
	 * @param session 获取uid/username
	 * @param request 获取服务器根目录
	 * @param avatar 获取上传文件名
	 * @return
	 */
	@PostMapping("change_avatar")
	public ResponseResult<String> changeAvatar(HttpSession session,HttpServletRequest request,@RequestParam("avatar") MultipartFile avatar){
		//检查是否上传空文件
		if(avatar.isEmpty()){
			throw new FileEmptyException("上传头像失败,请选择文件");
		}
		//检查文件大小是否超标
		long size = avatar.getSize();
		if(size>UPLOAD_AVATAR_MAX_SIZE){
			throw new FileSizeException("上传头像失败,文件太大");
		}
		//检查文件类型是否在允许范围内
		String contentType = avatar.getContentType();
		if(!UPLOAD_AVATAR_TYPES.contains(contentType)){
			throw new FileTypeException("上传头像失败,请更换文件类型");
		}
		/*
		 * 获取服务器目录地址:根目录+存储目录(判断)
		 */
		ServletContext contextPath = request.getServletContext();//获取服务器根路径
		String realPath = contextPath.getRealPath(UPLOAD_DIR );//设置根目录下的目录
		File parent = new File(realPath);//新建File对象
		if(!parent.exists()){//如果目录不存在新建目录
			parent.mkdirs();
		}
		/*
		 * 获取服务器文件地址:随机文件名+拓展名(判断)
		 */
		String originalFilename = avatar.getOriginalFilename();//获取上传文件名
		int last= originalFilename.lastIndexOf(".");//获取.的位置
		String substring="";//拓展名:默认null;
		if(last!=-1){//如果存在给substring赋值
			substring = originalFilename.substring(last);
		}
		String child= UUID.randomUUID().toString()+substring;
		/*
		 * 保存文件
		 */
		File file = new File(parent,child);
		try {
			//抛出异常:FileIOEception或者return responseResult
			avatar.transferTo(file);
		} catch (IllegalStateException e) {
			throw new FileStateException("上传头像失败,State异常");
		} catch (IOException e) {
			throw new FileIOException("上传头像失败,IO异常");
		}
		/*
		 * 保存数据
		 */
		Integer uid = getUidFromSession(session);
		String modifiedUser = session.getAttribute("username").toString();
		String avatarPath ="/"+UPLOAD_DIR +"/"+child;
		userService.changeAvatar(uid, avatarPath, modifiedUser);
		ResponseResult<String> responseResult = new ResponseResult<String>(SUCCESS);
		responseResult.setData(avatarPath);
		return responseResult;
	}
}
