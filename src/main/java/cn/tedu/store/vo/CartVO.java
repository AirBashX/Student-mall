package cn.tedu.store.vo;

import java.io.Serializable;

/**
 * 商品查询的VO类
 * @author ZSP
 *
 */
public class CartVO implements Serializable{
	
	private static final long serialVersionUID = 7045747691095869228L;
	
	Integer cid;
	Integer uid;
	Long gid;
	Integer num;
	String title;
	Long price;
	String image;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "CartVO [cid=" + cid + ", uid=" + uid + ", gid=" + gid + ", num=" + num + ", title=" + title + ", price="
				+ price + ", image=" + image + "]";
	}
	
}
