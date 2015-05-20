package com.zxl.app.model;

import java.io.Serializable;

/**
 * @author suger
 * 
 */
public class User_info extends BaseModel implements Serializable{
	private static final long serialVersionUID = 5022479447914904180L;
	private Integer id;
	private String sname;
	private String account;
	private String password;
	private String email;
	private Integer isAdmin = 0;
	private String cTime;//创建时间
	private String uTime;//更新时间
	private Integer status = 1;//0为删除1有效
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
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
