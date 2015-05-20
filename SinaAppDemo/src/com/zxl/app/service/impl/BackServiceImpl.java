package com.zxl.app.service.impl;

import java.util.List;

import com.zxl.app.model.User_info;
import com.zxl.app.model.Xiao_Hua;
import com.zxl.app.service.BackService;
import com.zxl.app.vo.Xiao_Hua_Vo;

public class BackServiceImpl  extends BaseManagerImpl implements BackService {
	
	//用户相关开始
	@Override
	public User_info findUserInfo(User_info un) {
		return (User_info) commonDao.find("findUserInfo", un);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User_info> findUserInfoList(User_info un){
		return (List<User_info>) commonDao.findList("findUserInfoList", un);
	}
	//用户相关结束
	
	
	//笑话相关开始
	@Override
	public Xiao_Hua findXiaoHuaById(Integer id) {
		return (Xiao_Hua) commonDao.find("findXiaoHuaById", id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Xiao_Hua> findXiaoHuaList(Xiao_Hua_Vo xhVo) {
		return (List<Xiao_Hua>) commonDao.findList("findXiaoHuaList", xhVo);
	}
	//笑话相关结束
	@Override
	public Long addXiaoHua(Xiao_Hua xh) {
		return commonDao.insert("addXiaoHua", xh);
	}
}
