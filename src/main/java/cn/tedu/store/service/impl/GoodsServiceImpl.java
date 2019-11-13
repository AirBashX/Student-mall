package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

/**
 * 业务类:商品数据
 * @author ZSP
 */
@Service
public class GoodsServiceImpl implements IGoodsService{
	
	@Autowired
	GoodsMapper goodsMapper;
	
	/**
	 * 业务方法:显示热门排行的商品
	 */
	@Override
	public List<Goods> getHostList() {
		List<Goods> hostList = findHostList();
		return hostList;
	}
	
	/**
	 * 业务方法:根据 id 显示商品详情
	 */
	@Override
	public Goods getById(Long id) {
		Goods goods = findByList(id);
		return goods;
	}
	
	/**
	 * 内部方法 查看热门商品
	 * @return List Goods
	 */
	public List<Goods> findHostList(){
		List<Goods> hostList = goodsMapper.findHostList();
		return hostList;
	}

	/**
	 * 内部方法 查看List
	 * @param id 客户端数据
	 * @return Goods
	 */
	public Goods findByList(Long id){
		return goodsMapper.findById(id);
	}
}
