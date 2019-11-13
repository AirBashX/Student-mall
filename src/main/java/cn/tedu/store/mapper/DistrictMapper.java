package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;

public interface DistrictMapper {
	/**
	 * 根据父级代号获取全国所有省市区
	 * @param parent 父级代号
	 * @return List 全国所有省/市/区列表
	 */
	List<District> findByParent(String parent);
	/**
	 * 根据代号获取省市区的详情
	 * @param code 省市区的代号
	 * @return List 省市区的详情
	 */
	District findByCode(String code);
	
}
