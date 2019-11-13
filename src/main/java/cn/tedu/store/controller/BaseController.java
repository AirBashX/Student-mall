package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.FileEmptyException;
import cn.tedu.store.service.ex.FileIOException;
import cn.tedu.store.service.ex.FileSizeException;
import cn.tedu.store.service.ex.FileStateException;
import cn.tedu.store.service.ex.FileTypeException;
import cn.tedu.store.service.ex.FileUploadException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.ResponseResult;

/**
 * 控制器基类:用于全局处理异常
 * @author ZSP
 *
 */
public abstract class BaseController {
	
	/**
	 * 响应结果时用于表示操作成功
	 */
	protected static final int SUCCESS = 200;
	
	/**
	 * 获取session中的integer类型UID
	 * @param session HttpSession
	 * @return uid
	 */
	protected final Integer getUidFromSession(HttpSession session){//本包中使用 不可被重写
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());//建议使用方法强转
		return uid;
	}
	
	//异常1要小于异常2;
	/**
	 * 异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ServiceException.class,FileUploadException.class})//异常1:什么异常要经过下列代码处理,默认是Throwable.class;
	public ResponseResult<Void> handleException(Exception e){//异常2:什么异常:异常要比下面异常大
		ResponseResult<Void> rr = new ResponseResult<>();
		if(e instanceof UsernameDuplicateException){
			//400用户名冲突异常
			rr.setState(400);
		}else if(e instanceof UserNotFoundException){
			//401用户名没有找到
			rr.setState(401);
		}else if(e instanceof PasswordNotMatchException){
			//402密码错误
			rr.setState(402);
		}else if(e instanceof AccessDeniedException) {
			//403客户端提交非用户数值异常
			rr.setState(403);
		}else if(e instanceof InsertException){
			//500插入数据异常
			rr.setState(500);
		}else if(e instanceof UpdateException){
			//501修改密码异常
			rr.setState(501);
		}else if(e instanceof FileEmptyException){
			//601上传空文件异常
			rr.setState(601);
		}else if(e instanceof FileSizeException){
			//602文件大小异常
			rr.setState(602);
		}else if(e instanceof FileTypeException){
			//603文件类型错误
			rr.setState(603);
		}else if(e instanceof FileStateException){
			//604上传头像额外异常
			rr.setState(604);
		}else if(e instanceof FileIOException){
			//605上传头像IO异常
			rr.setState(605);
		}else if(e instanceof AddressNotFoundException) {
			//700没有收货地址异常
			rr.setState(700);
		}else if(e instanceof CartNotFoundException) {
			//801商品没有找到异常
			rr.setState(800);
		}
		rr.setMessage(e.getMessage());
		return rr;
	}
}