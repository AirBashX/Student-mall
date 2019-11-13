package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;
/**
 * 业务类:cart
 * @author ZSP
 * @see ICartService
 */
@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartMapper cartMapper;
	
	/**
	 * 添加到购物车
	 */
	@Override
	public void addCart(Cart cart,String username) throws UpdateException,InsertException{
		Date date = new Date();
		Integer uid = cart.getUid();
		Long gid = cart.getGid();
		Cart result = select(uid, gid);
		//检测是否为第一次添加 ,是返回null
		if(result == null) {
			cart.setCreatedTime(date);
			cart.setModifiedTime(date);
			cart.setCreatedUser(username);
			cart.setModifiedUser(username);
			insert(cart);
		}else {
			Integer cid = result.getCid();
			Integer oldNum = result.getNum();
			Integer newNum = cart.getNum();
			Integer num = newNum+oldNum;
			num++;
			update(num, cid, username,date);
		}
	}
	
	/**
	 * 显示购物车列表
	 */
	@Override
	public List<CartVO> getByUid(Integer uid) {
		List<CartVO> cartVO = cartMapper.findByUid(uid);
		return cartVO;
	}
	
	@Override
	public Integer addNum(Integer cid,Integer uid,String username) throws CartNotFoundException,AccessDeniedException{
		Cart cart = getByCid(cid);
		//检验购物车数据是否存在,null代表不存在
		if(cart==null) {
			throw new CartNotFoundException("要修改的商品不存在");
		}
		//检验数据是否来自用户,flase代表不是
		if(cart.getUid()!=uid) {
			throw new AccessDeniedException();
		}
		Integer num = cart.getNum();
		num++;
		Date time = new Date();
		//更新数据
		update(num, cid, username, time);
		return num;
	}
	
	@Override
	public List<CartVO> getByCids(Integer[] cid) {
		return cartMapper.findByCids(cid);
	}
	
	/**
	 * 检验是第几次添加
	 * @param uid session中用户id
	 * @param gid 商品id
	 * @return 返回cart cid num
	 */
	public Cart select(Integer uid,Long gid) {
		Cart cart = cartMapper.select(uid, gid);
		return cart;
	}
	
	/**
	 * 第一次添加
	 * @param cart 添加数据
	 * @return 结果
	 */
	public void insert(Cart cart) {
		Integer rows = cartMapper.insert(cart);
		if(rows !=1) {
			throw new InsertException("添加购物车失败");
		}
	}
	
	/**
	 * 非第二次添加
	 * @param num 数量
	 * @param cid cid
	 * @param modifiedUser 更改者
	 */
	public void update(Integer num,Integer cid,String modifiedUser,Date modifiedTime ) {
		Integer rows = cartMapper.update(num, cid, modifiedTime, modifiedUser);
		if(rows !=1) {
			throw new UpdateException("添加购物车失败");
		}
	}

	/**
	 * 根据cid检测数据是否来自同一用户
	 * @param cid 商品id
	 * @return cart:uid/num
	 */
	public Cart getByCid(Integer cid) {
		return cartMapper.findByCid(cid);
	}

}
