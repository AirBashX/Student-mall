package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Goods;

/**
 * 持久层:商品
 * @author ZSP
 */
public interface GoodsMapper {
	
	/**
	 * 持久层方法:根据优先级查找主页热门
	 * @return List Goods
	 */
	List<Goods> findHostList();
	
	/**
	 * 持久层方法:根据ID查看商品详情
	 * @return
	 */
	Goods findById(Long i);
}
