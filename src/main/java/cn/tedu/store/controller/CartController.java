package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.ResponseResult;
import cn.tedu.store.vo.CartVO;

/**
 * 控制类:购物车
 * @author ZSP
 *
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
	@Autowired
	ICartService CartService;
	
	/**
	 * 控制类方法:添加购物车
	 * @param gid
	 * @param session
	 */
	@PostMapping("add_cart")
	public ResponseResult<Void> addCart(Cart cart,Integer num,HttpSession session) {
		String username = session.getAttribute("username").toString();
		Integer uid = getUidFromSession(session);
		cart.setUid(uid);
		cart.setNum(num);
		CartService.addCart(cart, username);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	/**
	 * 控制类方法:查看购物车列表
	 * @param session
	 * @return 购物车列表
	 */
	@PostMapping("/")
	public ResponseResult<List<CartVO>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<CartVO> cartVO = CartService.getByUid(uid);
		return new ResponseResult<List<CartVO>>(SUCCESS,cartVO);
		
	}
	
	/**
	 * 控制类方法:增加num
	 * @param cid html中的cid
	 * @param session 
	 * @return 
	 */
	@PostMapping("{cid}/add_num")
	public ResponseResult<Integer> addNum(@PathVariable("cid") Integer cid,HttpSession session){
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		Integer num = CartService.addNum(cid, uid, username);
		return new ResponseResult<>(SUCCESS,num);
	}
	
	/**
	 * 控制类方法:显示num
	 * @param cids
	 * @return
	 */
	@GetMapping("get_by_cids")
	public ResponseResult<List<CartVO>> getBycids(Integer[] cids){
		List<CartVO> cid = CartService.getByCids(cids);
		return new ResponseResult<List<CartVO>>(SUCCESS,cid);
	}
}
