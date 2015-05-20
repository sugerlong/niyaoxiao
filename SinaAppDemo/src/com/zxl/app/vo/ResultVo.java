package com.zxl.app.vo;

import java.io.Serializable;

/**
 * 接口返回的泛型封装对象，包括：返回码、返回提示信息和返回对象
 * 
 * @author suger
 * @create 2015-04-20
 */
public class ResultVo<T> implements Serializable{
	
	private static final long serialVersionUID = -6475386067850454344L;

	/** success code */
	public static final String SUCCESS = "0";

	/**
	 * 接口返回码
	 * 处理成功，则code值为0，其他值表示处理异常，包括验证不通过等
	 */
	private String code = SUCCESS;
	
	/**
	 * 接口返回提示信息
	 * 如果接口调用成功，则为success，否则为具体错误信息
	 */
	private String msg = "success";
	
	/**
	 * 接口返回对象
	 * 返回对象具体类型在创建当前类时指定
	 */
	private T valueObj;
	
	/**
	 * 构造函数（接口调用成功时）
	 * 
	 * @param valueObj 接口返回对象
	 */
	public ResultVo(T valueObj){
		this.valueObj = valueObj;
	}
	
	/**
	 * 构造函数（接口调用失败时）
	 * 
	 * @param code 接口返回码
	 * @param msg 接口返回提示信息
	 */
	public ResultVo(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	/**
	 * 构造函数（接口调用失败时并且需要指定返回对象，多用于二维的错误提示，比如批量接口）
	 * 
	 * @param code 接口返回码
	 * @param msg 接口返回提示信息
	 * @param valueObj 接口返回对象
	 */
	public ResultVo(String code,String msg,T valueObj){
		this.code = code;
		this.msg = msg;
		this.valueObj = valueObj;
	}
	
	/**
	 * 获得接口返回码
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置接口返回码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 获得接口返回提示信息
	 */
	public String getMsg() {
		return msg;
	}
	
	/**
	 * 设置接口返回提示信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 获得接口返回对象
	 */
	public T getValueObj() {
		return valueObj;
	}
	
	/**
	 * 设置接口返回对象
	 */
	public void setValueObj(T valueObj) {
		this.valueObj = valueObj;
	}

	@Override
	public String toString() {
		return "ResultVo [code=" + code + ", msg=" + msg + ", valueObj="
				+ valueObj + "]";
	}
}
