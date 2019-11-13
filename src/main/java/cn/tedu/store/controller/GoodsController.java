package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.util.ResponseResult;

/**
 * 控制类:Goods
 * @author ZSP
 */
@RestController
@RequestMapping("goods")
public class GoodsController extends BaseController{
	
	@Autowired
	private IGoodsService goodsService;
	
	/**
	 * 控制方法:获取热门商品列表
	 * @return 结果+List goods
	 */
	@GetMapping("hot")
	public ResponseResult<List<Goods>> getHostList(){
		List<Goods> hostList = goodsService.getHostList();
		return new ResponseResult<List<Goods>>(SUCCESS,hostList);
	}
	/**
	 * 控制方法:
	 * @param id
	 * @return
	 */
	@GetMapping("{id}/details")
	public ResponseResult<Goods> getById(@PathVariable("id") Long id){
		Goods goods = goodsService.getById(id);
		return new ResponseResult<Goods>(SUCCESS,goods);
	}
}
