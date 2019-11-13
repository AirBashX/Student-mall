package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;

public interface AddressMapper {
	/**
	 * 查询address条数
	 * @param user
	 * @return Integer 测试
	 */
	Integer countByUid(Integer uid);
	/**
	 * 插入地址
	 * @param address
	 * @return Integer 检测
	 */
	Integer insert(Address address);
	/**
	 * 根据用户id查询收货地址列表
	 * @param session中uid
	 * @return 地址列表
	 */
	List<Address> findByUid(Integer uid);
	
	/**
	 * 在修改默认地址之前查询地址是否存在(返回地址已被删除)
	 * @param aid
	 * @return 修改条目
	 */
	Address findByAid(Integer aid);
	/**
	 * 在修改默认地址之前,将之前的默认值清空
	 * @return 修改条目
	 */
	Integer updateNoDefault(Integer uid);
	/**
	 * 根据收货地址id修改地址为默认
	 * @param uid session中的uid
	 * @param modified_user seesison总的username
	 * @param modified_time 修改时间
	 * @return 修改条目
	 */
	Integer updateDefault(@Param("aid") Integer aid,@Param("modifiedUser") String modifiedUser,@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 根据uid删除收货地址
	 * @param aid 
	 * @return 删除条目
	 */
	Integer deleteByAid(Integer aid);
	/**
	 * 根据uid查找最后一个修改的aid
	 * @param uid session中的uid
	 * @return aid 最后一修改的aid
	 */
	Integer aidByUid(Integer uid);
}
