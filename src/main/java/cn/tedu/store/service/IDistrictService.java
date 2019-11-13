package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 * 业务类接口:根据父级编号获取全国所有省市区列表
 * @author ZSP
 *@return 全国省市区;列表
 */
public interface IDistrictService {
	/**
	 * 根据父级编号获取全国所有省市区列表
	 * @param parent
	 * @return list
	 */
	List<District> getByParent(String parent);
	/**
	 * 根据代号获取省市区的详情
	 * @param code 省市区的代号
	 * @return District 省市区的详情
	 */
	District getBycode(String code);
}
