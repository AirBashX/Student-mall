package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * 业务类接口:
 * @author ZSP
 *@return void
 */
public interface ICartService {
	/**
	 * 业务接口方法:添加到购物车
	 * @param cart 购物车数据
	 * @param username 用户名
	 * @throws UpdateException 更新错误
	 * @throws InsertException 增加错误
	 */
	void addCart(Cart cart,String username) throws UpdateException,InsertException;
	
	/**
	 * 业务接口方法:查看购物车列表
	 * @param uid session中用户id
	 * @return CartVO
	 */
	List<CartVO> getByUid(Integer uid);
	
	/**
	 * 业务接口方法:增加购物车列表的num值
	 * @param cid 购物车id
	 * @param uid session用户id
	 * @param username session用户名称
	 * @throws CartNotFoundException
	 * @throws UpdateException
	 * @throws AccessDeniedException
	 */
	Integer addNum(Integer cid,Integer uid,String username) throws CartNotFoundException,UpdateException,AccessDeniedException;
	
	/**
	 * 业务接口方法:根据aids获取用户CartVO数据
	 * @param aid
	 * @return CartVO
	 */
	List<CartVO> getByCids(Integer[] cid);
}
