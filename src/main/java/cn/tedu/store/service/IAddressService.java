package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * 业务类接口:地址相关
 * @author ZSP
 */
public interface IAddressService {
	/**
	 * 业务类接口:增加地址
	 * @param address 输入的地址信息+sessionUid
	 * @param username session中的username
	 * @throws InsertException
	 */
	void addnew(Address address,String username) throws InsertException;
	
	/**
	 * 业务类接口:查询收货列表
	 * @param uid session中uid
	 * @return 收货列表
	 */
	List<Address> getByUid(Integer uid);
	
	/**
	 * 业务类接口:修改默认收货地址
	 * @param uid session中的uid
	 * @param aid "查询收货地址"中的aid
	 * @param username session中的username
	 * @throws UpdateException 更新失败异常
	 * @throws AddressNotFoundException 查询不到收货地址异常
	 */
	void setDefalut(Integer uid,Integer aid,String username) throws UpdateException,AddressNotFoundException,AccessDeniedException;
	
	/**
	 * 业务类接口:删除收货地址
	 * @param uid sesison中的uid
	 * @param aid "客户端源码提交的aid"
	 * @param username session中的uid
	 * @throws UpdateException 更新失败异常
	 * @throws AddressNotFoundException 查询拜倒收货地址异常
	 */
	void delete(Integer uid,Integer aid,String username) throws UpdateException,AddressNotFoundException,DeleteException,AccessDeniedException;
	
	/**
	 * 业务类接口:根据aid查看Address信息
	 * @param aid
	 * @return Address
	 */
	Address getByAid(Integer aid);
}
