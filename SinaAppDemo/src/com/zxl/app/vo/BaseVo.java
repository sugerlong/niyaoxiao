package com.zxl.app.vo;

public abstract class BaseVo {
	
	/**分页下标-开始位置，从0开始*/
	private Long start = 0l;

	/**每页的记录数*/
	private Long limit = 6L;

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}
}
