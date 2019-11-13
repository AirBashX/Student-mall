package cn.tedu.store.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.IDistrictService;

/**
 * 业务类:省市区列表
 * @author ZSP
 */
@Service
public class DistrictServiceImpl implements IDistrictService{

	@Autowired
	private DistrictMapper districtMapper;

	/**
	 * 业务类方法
	 */
	@Override
	public List<District> getByParent(String parent) {
		return findByParent(parent);
	}

	@Override
	public District getBycode(String code) {
		return findBycode(code);
	}
	
	/**
	 * 实现持久层方法:根据父级编号获取全国所有省市区列表
	 * @param parent 父级编号
	 * @return districtMapper
	 */
	private List<District> findByParent(String parent) {
		return districtMapper.findByParent(parent);
	}
	/**
	 * 实现持久层方法:根据编号获取全国所有省市区
	 * @param code	地址编号
	 * @return districtMapper
	 */
	public District findBycode(String code) {
		return districtMapper.findByCode(code);
	}
	

}