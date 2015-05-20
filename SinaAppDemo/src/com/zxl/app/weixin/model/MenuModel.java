package com.zxl.app.weixin.model;

import java.io.Serializable;

public class MenuModel implements Serializable{
	/**
	 * zxl
	 */
	private static final long serialVersionUID = 5861929850831797693L;
	private String id; // id
    private String title; //菜单名称
	private String type;//1.click 2.view
	private String keyCode;//微信触发事件Key值
	private String parentId;//父节点Id，没有父节点为0(为0的为主菜单)
	private String status;//1.有效   0.无效
	private String cTime;//创建时间
	private String uTime;//更新时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getcTime() {
		return cTime;
	}
	public void setcTime(String cTime) {
		this.cTime = cTime;
	}
	public String getuTime() {
		return uTime;
	}
	public void setuTime(String uTime) {
		this.uTime = uTime;
	}
	
}
