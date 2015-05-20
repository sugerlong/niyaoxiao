package com.zxl.app.weixin.model;

import java.io.Serializable;

public class MessageModel implements Serializable{
	/**
	 * zxl
	 */
	private static final long serialVersionUID = -2791305433425064155L;
	private String id; // id
    private String title; //菜单名称
	private String messageType;//1.文字 2.图文
	private String keyCode;//微信触发事件Key值
	private String keyType;//1.click 2.view
	private String picUrl;//图片链接地址
	private String picUrlTitle;//图片title
	private String linkUrl;//跳转链接URL
	private String description;//消息描述
	private String mark;//备注
	private String noEdit;//1不可删除（固定消息）
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
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getNoEdit() {
		return noEdit;
	}
	public void setNoEdit(String noEdit) {
		this.noEdit = noEdit;
	}
	public String getPicUrlTitle() {
		return picUrlTitle;
	}
	public void setPicUrlTitle(String picUrlTitle) {
		this.picUrlTitle = picUrlTitle;
	}
	
}
