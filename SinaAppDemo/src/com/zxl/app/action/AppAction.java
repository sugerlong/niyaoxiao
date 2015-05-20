package com.zxl.app.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zxl.app.db.DBUtil;
import com.zxl.app.model.User_info;


public class AppAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142001158497642903L;
	 
	private String deviceId;//设备id
    private String deviceType;//设备类型 1 ios 2 android
    private String mobileName;//手机类型 如iphone5s
    private String systemVersion;//手机操作系统版本
	private String userCode;//登录名
	private String versionId;//应用版本id
	List<User_info> userList;
	
	public String index(){
		userList = new ArrayList<User_info>();
		return SUCCESS;
	}
	
	public String getUserInfo(){
		Connection con = DBUtil.getCon();//应用版本id
        Statement stmt=null;
        ResultSet  rs=null;
        String sql="select * from user_info";
        stmt=DBUtil.createStat(con);
         try {
            rs=stmt.executeQuery(sql);
            userList = new ArrayList<User_info>();
            if(rs.next()){  
            	User_info user=new User_info();
                user.setId(rs.getInt("ID"));
                user.setSname(rs.getString("sname"));
                user.setAccount(rs.getString("account"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));       
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    
		return SUCCESS;
	}
	
	
	public String html5Test(){
		return SUCCESS;
	}
	//html5 Demo页面
	public String html5Demo(){
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
	
}
