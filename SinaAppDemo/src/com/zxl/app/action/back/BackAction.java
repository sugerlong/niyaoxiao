package com.zxl.app.action.back;

import java.util.ArrayList;
import java.util.List;

import com.zxl.app.action.BaseAction;
import com.zxl.app.model.User_info;
import com.zxl.app.model.Xiao_Hua;
import com.zxl.app.service.BackService;
import com.zxl.app.vo.Xiao_Hua_Vo;


public class BackAction extends BaseAction{

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
	private List<User_info> userList;
	private User_info userInfo;
	private Xiao_Hua xiaoHua;
	private List<Xiao_Hua> xhList;
	private Xiao_Hua_Vo xhVo;
	
	private String errorMseeage;//错误信息
	
	public String login(){
		if(null==userInfo){
			return LOGIN;
		}else{
			return SUCCESS;
		}
	}
	public String vlogin(){
		userInfo = new User_info();
		userInfo.setId(1);
		this.backService.findUserInfo(userInfo);
		if(null==userInfo){
			errorMseeage = "用户名和密码不正确";
//			return "logoutTest";
			return LOGOUT;
		}else{
			User_info un = this.backService.findUserInfo(userInfo);
			if(null!=un&&null!=un.getId()){
				return SUCCESS;
			}else{
				errorMseeage = "用户名和密码不正确";
				return LOGOUT;
			}
		}
	}
	
	public String index(){
		userList = new ArrayList<User_info>();
		User_info uinfo = new User_info();
		uinfo.setId(1);
		uinfo.setAccount("zhangxiulong");
		uinfo.setSname("张修龙");
		uinfo.setIsAdmin(0);
		userList.add(uinfo);
		
		User_info uinfo1 = new User_info();
		uinfo1.setId(2);
		uinfo1.setAccount("admin");
		uinfo1.setSname("admin");
		uinfo1.setIsAdmin(1);
		userList.add(uinfo1);
		
		return SUCCESS;
	}
	/**
	 * 跳转到新增笑话界面
	 * @return
	 */
	public String toAddArticle(){
		return SUCCESS;
	}
	/**
	 * 新增笑话
	 * @return
	 */
	public String addArticle(){
		if(null!=xiaoHua){
			this.backService.addXiaoHua(xiaoHua);
		}
		return SUCCESS;
	}
	/**
	 * 跳转到笑话查询页面
	 * @return
	 */
	public String toQueryArticleList(){
		if(null==xhVo){
			xhVo = new Xiao_Hua_Vo();
		}
		xhList = this.backService.findXiaoHuaList(xhVo);
		return SUCCESS;
	}
	/**
	 * 笑话查询List
	 * @return
	 */
	public String queryArticleList(){
		if(null==xhVo){
			xhVo = new Xiao_Hua_Vo();
		}
		xhList = this.backService.findXiaoHuaList(xhVo);
		return SUCCESS;
	}
	
	
	public String queryUserList(){
		userList = new ArrayList<User_info>();
		User_info uinfo = new User_info();
		uinfo.setId(1);
		uinfo.setAccount("zhangxiulong");
		uinfo.setSname("张修龙");
		uinfo.setIsAdmin(0);
		userList.add(uinfo);
		
		User_info uinfo1 = new User_info();
		uinfo1.setId(2);
		uinfo1.setAccount("admin");
		uinfo1.setSname("admin");
		uinfo1.setIsAdmin(1);
		userList.add(uinfo1);
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
	public void setUserInfo(User_info userInfo) {
		this.userInfo = userInfo;
	}
	public String getErrorMseeage() {
		return errorMseeage;
	}
	public void setErrorMseeage(String errorMseeage) {
		this.errorMseeage = errorMseeage;
	}
	public BackService getBackService() {
		return backService;
	}
	public void setBackService(BackService backService) {
		this.backService = backService;
	}
	public Xiao_Hua getXiaoHua() {
		return xiaoHua;
	}
	public void setXiaoHua(Xiao_Hua xiaoHua) {
		this.xiaoHua = xiaoHua;
	}
	public User_info getUserInfo() {
		return userInfo;
	}
	public Xiao_Hua_Vo getXhVo() {
		return xhVo;
	}
	public void setXhVo(Xiao_Hua_Vo xhVo) {
		this.xhVo = xhVo;
	}
	public List<Xiao_Hua> getXhList() {
		return xhList;
	}
	public void setXhList(List<Xiao_Hua> xhList) {
		this.xhList = xhList;
	}
}
