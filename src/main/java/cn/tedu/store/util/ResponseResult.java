package cn.tedu.store.util;

import java.io.Serializable;

/**
 * 返回类:注册时返回的数据
 * @author ZSP
 *
 * @param <T> 如果控制器会向客户端响应某些数据,则表示响应的数据类
 */
public class ResponseResult<T> implements Serializable{
	
	private static final long serialVersionUID = -6368131160298155954L;
	
	private Integer state;
	private String message;
	private T data;
	
	public ResponseResult() {
		super();
	}
	
	public ResponseResult(Integer state) {
		super();
		this.state = state;
	}
	
	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public ResponseResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
	
	public short shortValue() {
		return state.shortValue();
	}
	public int intValue() {
		return state.intValue();
	}
	public long longValue() {
		return state.longValue();
	}
	public float floatValue() {
		return state.floatValue();
	}
	public double doubleValue() {
		return state.doubleValue();
	}
	public int hashCode() {
		return state.hashCode();
	}
	public boolean equals(Object obj) {
		return state.equals(obj);
	}
	public int compareTo(Integer anotherInteger) {
		return state.compareTo(anotherInteger);
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}
