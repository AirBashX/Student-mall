package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Order;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.util.ResponseResult;

/**
 * 控制类:订单数据
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController{

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/")
	public ResponseResult<Order> create(HttpSession session,Integer[] cids,Integer aid){
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		Order order = orderService.create(cids, aid, username, uid);
		return new ResponseResult<Order>(SUCCESS,order);
	}
}
