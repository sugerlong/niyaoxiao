package com.zxl.app.service;

import java.util.List;

import com.zxl.app.model.User_info;
import com.zxl.app.model.Xiao_Hua;
import com.zxl.app.vo.Xiao_Hua_Vo;



public interface BackService {
	/**
	 * 根据用户条件查询用户
	 * @param un
	 * @return
	 */
	
	User_info findUserInfo(User_info un);
	/**
	 * 根据用户条件查询用户List
	 * @param un
	 * @return
	 */
	List<User_info> findUserInfoList(User_info un);
	/**
	 * 根据xiaohua  ID查笑话
	 * @param un
	 * @return
	 */
	Xiao_Hua findXiaoHuaById(Integer id);
	/**
	 * 根据条件查询笑话List
	 * @param un
	 * @return
	 */
	List<Xiao_Hua> findXiaoHuaList(Xiao_Hua_Vo xhVo);
	/**
	 * 笑话新增
	 * @param un
	 * @return
	 */
	Long addXiaoHua(Xiao_Hua xh);
	
}
