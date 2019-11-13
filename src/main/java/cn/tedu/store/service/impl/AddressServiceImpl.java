package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * 业务类:地址
 * @author ZSP
 *
 */
@Service
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private AddressMapper addressMapper;
	
	/**
	 * 业务类方法:增加地址
	 */
	@Override
	public void addnew(Address address, String username) throws InsertException {
		//根据uid查询数量
		Integer uid = address.getUid();
		Integer count = addressMapper.countByUid(uid);
		//当收货地址为0时为1
		Integer isDefault=count==0?1:0;
		address.setIsDefault(isDefault);
		//获取省市区的名称:获取address中的地址省市区编号
		String district = getDistrict(address.getProvince(), address.getCity(), address.getArea());
		//调用下面的方法:
		address.setDistrict(district);
		//添加日志
		Date date = new Date();
		address.setCreatedTime(date);
		address.setModifiedTime(date);
		address.setCreatedUser(username);
		address.setModifiedUser(username);
		//调用执行
		insert(address);
	}
	/**
	 * 业务类方法:获取收货地址列表
	 */
	@Override
	public List<Address> getByUid(Integer uid) {
		List<Address> list = addressMapper.findByUid(uid);
		return list;
	}
	
	/**
	 * 增加地址的内部方法:执行增加
	 * @param address 地址信息
	 */
	private void insert(Address address){
		Integer rows = addressMapper.insert(address);
		if(rows!=1){
			throw new InsertException("增加地址失败");
		}
	}
	
	@Autowired
	private IDistrictService districtService;
	/**
	 * 内部方法:根据省市区的编号获取地址名称并拼接
	 * @param provinceCode 省编号
	 * @param cityCode	市编号
	 * @param areaCode 区编号
	 * @return 
	 */
	private String getDistrict(String provinceCode,String cityCode,String areaCode){
		StringBuffer result = new StringBuffer();
		District province = districtService.getBycode(provinceCode);
		District city = districtService.getBycode(cityCode);
		District area = districtService.getBycode(areaCode);
		if(province !=null){
			result.append(province.getName());
		}
		if(city !=null){
			result.append(city.getName());
		}
		if(area !=null){
			result.append(area.getName());
		}
		return result.toString();
	}
	
	/**
	 * 业务类方法:修改默认收货地址
	 */
	@Transactional
	@Override
	public void setDefalut(Integer uid,Integer aid,String username) throws UpdateException,AddressNotFoundException,AccessDeniedException{
		Address result = getByAid(aid);//内部方法
		if(result==null) {//判断收货地址列表是否存在,没有返回null
			throw new AddressNotFoundException("要查询的收货地址不存在");
		}
		if(result.getUid()!=uid) {//判断aid是否正常提交的(比较查询结果中uid和参数uid是否不一致)
			 throw new AccessDeniedException("客户端提交的数据并非从正常用户处获取");
		}
		Integer rowNoDefault = updateNoDefault(uid);
		if(!(rowNoDefault>=0)) {//判断更新数据是否成功,1成功
			throw new UpdateException("修改默认值失败");
		}
		Date date = new Date();
		Integer rowdefault = updateDefault(aid, username, date);
		if(rowdefault!=1) {//判断更新数据是否成功,1成功
			throw new UpdateException("修改默认值失败");
		}
	}
	
	/**
	 * 业务类:删除收货地址
	 */
	@Transactional
	@Override
	public void delete(Integer uid, Integer aid, String username) throws UpdateException,AddressNotFoundException,DeleteException,AccessDeniedException {
		Address result = getByAid(aid);
		//判断是否有收货地址,没有返回null
		if(result == null) {
			throw new AddressNotFoundException("要删除的收货地址不存在");
		}
		//判断检验数据是否来自用户,不是返回false
		if(result.getUid() != uid) {
			throw new AccessDeniedException("数据访问异常");
		}
		Integer rowdefault = result.getIsDefault();
		//判断是否删除成功,成功返回1
		Integer rowDelete = addressMapper.deleteByAid(aid);
		if(rowDelete !=1) {
			throw new DeleteException();
		}
		//判断删除的是否为默认值,是返回1并重新设置默认值
		if(rowdefault == 1) {
			Integer LastAid = getLastAid(uid);
			Date date = new Date();
			Integer row = updateDefault(LastAid, username, date);
			if(row != 1) {
				throw new UpdateException();			
			}
		}
	}
	
	@Override
	public Address getByAid(Integer aid) {
		Address result = addressMapper.findByAid(aid);
		return result;
	}
	
	/**
	 * 修改默认收货地址的内部方法:执行全部设置为非默认
	 * @param uid session中的uid
	 * @return 执行结果
	 */
	public Integer updateNoDefault(Integer uid) {
		Integer rowNoDefault = addressMapper.updateNoDefault(uid);
		return rowNoDefault;
	}
	/**
	 * 修改默认收货地址的内部方法:执行设置为默认
	 * @param aid 客户端html数据
	 * @param username seesion中的username
	 * @param date 当前时间
	 * @return 执行结果
	 */
	public Integer updateDefault(Integer aid,String username,Date date) {
		Integer rowdefault = addressMapper.updateDefault(aid, username, date);
		return rowdefault;
	}
	/**
	 * 查看uid最后修改的aid
	 * @return aid 最后修改的aid
	 */
	public Integer getLastAid(Integer uid) {
		Integer aid = addressMapper.aidByUid(uid);
		return aid;
	}
}