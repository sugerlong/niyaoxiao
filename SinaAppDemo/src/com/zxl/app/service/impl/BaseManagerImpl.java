package com.zxl.app.service.impl;

import com.zxl.app.dao.CommonDao;
import com.zxl.app.service.BaseManager;

public abstract class BaseManagerImpl implements BaseManager {
	public CommonDao commonDao;
	
	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
}
