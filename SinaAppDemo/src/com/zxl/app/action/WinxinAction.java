package com.zxl.app.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zxl.app.model.User_info;
import com.zxl.app.model.Xiao_Hua;
import com.zxl.app.service.BackService;
import com.zxl.app.vo.Xiao_Hua_Vo;


public class WinxinAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142001158497642903L;
	private BackService backService;
	private String deviceId;//设备id
    private String deviceType;//设备类型 1 ios 2 android
    private String mobileName;//手机类型 如iphone5s
    private String systemVersion;//手机操作系统版本
	private String userCode;//登录名
	private String versionId;//应用版本id
	List<User_info> userList;
	private List<Xiao_Hua> xhList;
	private Xiao_Hua_Vo xhVo;
	public String index(){
		userList = new ArrayList<User_info>();
		return SUCCESS;
	}
	
	public String findXHList(){
		if(null==xhVo){
			xhVo = new Xiao_Hua_Vo();
		}
		xhList = this.backService.findXiaoHuaList(xhVo);
		return SUCCESS;
	}
	
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public List<User_info> getUserList() {
		return userList;
	}

	public void setUserList(List<User_info> userList) {
		this.userList = userList;
	}

	public BackService getBackService() {
		return backService;
	}

	public void setBackService(BackService backService) {
		this.backService = backService;
	}

	public List<Xiao_Hua> getXhList() {
		return xhList;
	}

	public void setXhList(List<Xiao_Hua> xhList) {
		this.xhList = xhList;
	}

	public Xiao_Hua_Vo getXhVo() {
		return xhVo;
	}

	public void setXhVo(Xiao_Hua_Vo xhVo) {
		this.xhVo = xhVo;
	}
	
}
