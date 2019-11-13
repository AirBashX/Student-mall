package cn.tedu.store.entity;

import java.util.Date;

/**
 * 订单数据实体类
 * @author ZSP
 *
 */
public class Order extends BaseEntity{
	
	private static final long serialVersionUID = -5199978099098896799L;
	
	private Integer oid;
	private Integer uid;
	private String recvName;
	private String recvPhone;
	private String recvAddress;
	private Long totalPrice;
	private Integer status;
	private Date orderTime;
	private Date payTime;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", recvName=" + recvName + ", recvPhone=" + recvPhone
				+ ", recvAddress=" + recvAddress + ", totalPrice=" + totalPrice + ", status=" + status + ", orderTime="
				+ orderTime + ", payTime=" + payTime + "]";
	}
}
