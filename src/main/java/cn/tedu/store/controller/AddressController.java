package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.util.ResponseResult;

/**
 * 控制类:地址相关
 * @author ZSP
 *
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{
	
	@Autowired
	private IAddressService addressService;
	/**
	 * 控制类方法:增加收货地址
	 * @param address
	 * @param session
	 * @return
	 */
	@RequestMapping("addnew")
	public ResponseResult<Void> addnew(Address address,HttpSession session){
		Integer uid = getUidFromSession(session);
		address.setUid(uid);
		String username = session.getAttribute("username").toString();
		addressService.addnew(address, username);
		return new ResponseResult<>(SUCCESS);
	}
	/**
	 * 控制类方法:查看收货地址列表
	 * @param session 获取uid
	 * @return 成功+收货地址列表
	 */
	@GetMapping("/")
	public ResponseResult<List<Address>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<Address> address = addressService.getByUid(uid);
		return new ResponseResult<>(SUCCESS,address);
	}
	/**
	 * 控制类方法:设置为默认收货地址
	 * @param session 获取uid username
	 * @param aid 客户端源码
	 * @return 成功
	 */
	@PostMapping("/{aid}/set_default")
	public ResponseResult<Void> setDefault(HttpSession session,@PathVariable("aid") Integer aid){
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		addressService.setDefalut(uid, aid, username);
		return new ResponseResult<>(SUCCESS);
		
	}
	/**
	 * 控制类方法:删除默认收货地址
	 * @param session 获取uid username
	 * @param aid 客户端源码
	 * @return 成功
	 */
	@PostMapping("/{aid}/delete_default")
	public ResponseResult<Void> deleteDefault(HttpSession session,@PathVariable("aid") Integer aid){
		System.err.println(1);
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		addressService.delete(uid, aid, username);
		return new ResponseResult<>(SUCCESS);
	}
}
