package com.zxl.app.model;

import java.io.Serializable;

/**
 * xiaohua附件
 * @author suger
 * 
 */
public class Xiao_Hua_Attachment implements Serializable{
	private static final long serialVersionUID = 5022479447914904180L;
	private int id;//ID
	private int x_h_id;//Xiao_Hua表的ID
	private String attachment_url;//附件地址
	private String cTime;//创建时间
	private String uTime;//更新时间
	private Integer status = 1;//0为删除1有效
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX_h_id() {
		return x_h_id;
	}
	public void setX_h_id(int x_h_id) {
		this.x_h_id = x_h_id;
	}
	public String getAttachment_url() {
		return attachment_url;
	}
	public void setAttachment_url(String attachment_url) {
		this.attachment_url = attachment_url;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
