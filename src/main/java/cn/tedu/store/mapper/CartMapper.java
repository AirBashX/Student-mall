package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

public interface CartMapper {
	
	/**
	 * 添加购物车数据
	 * @param cart 购物车数据
	 * @return 添加条目
	 */
	Integer insert(Cart cart);
	
	/**
	 * 更新购物车条目
	 * @param cart 购物车数据
	 * @return 添加条目
	 */
	Integer update(@Param("num") Integer num,@Param("cid") Integer cid,@Param("modifiedTime") Date modifiedTime,@Param("modifiedUser") String modifiedUser);
	
	/**
	 * 查看是否有条目
	 * @param uid
	 * @return 结果
	 */
	Cart select(Integer uid, Long gid);
	
	/**
	 * 查看购物车列表
	 * @param uid 用户id
	 * @return 购物车列表
	 */
	List<CartVO> findByUid(Integer uid);
	
	/**
	 * 根据Cid检测数据是否来自同一个uid中
	 * @param cid 购物车cid
	 * @return Cart
	 */
	Cart findByCid(Integer cid);
	
	/**
	 * 根据Cids选择购物车列表
	 * @param cid 购物车cid
	 * @return CartVO
	 */
	List<CartVO> findByCids(Integer[] cid);
	
}
