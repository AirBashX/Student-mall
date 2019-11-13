package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Goods;

/**
 * 业务抽象类:商品数
 * @author ZSP
 */
public interface IGoodsService {
	/**
	 * 业务抽象方法:前4项商品的数据列表
	 * @return List<Goods>
	 */
	List<Goods> getHostList();
	
	/**
	 * 业务抽象类:查看商品详情
	 * @return Goods
	 */
	Goods getById(Long id);
}
