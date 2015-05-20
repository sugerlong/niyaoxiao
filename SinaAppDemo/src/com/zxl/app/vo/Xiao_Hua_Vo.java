package com.zxl.app.vo;

import java.io.Serializable;

/**
 * @author suger
 * 
 */
public class Xiao_Hua_Vo extends BaseVo implements Serializable{
	private static final long serialVersionUID = 5022479447914904180L;
	private Integer id;//ID
	private String title;//标题
	private String fuTitle;//父标题
	private String content;//内容
	private String cTime;//创建时间
	private String uTime;//更新时间
	private Integer status = 1;//0为删除1有效
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getFuTitle() {
		return fuTitle;
	}


	public void setFuTitle(String fuTitle) {
		this.fuTitle = fuTitle;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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


	public Xiao_Hua_Vo() {
	}

}
