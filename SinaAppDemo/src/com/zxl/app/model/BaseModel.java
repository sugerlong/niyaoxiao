package com.zxl.app.model;

public abstract class BaseModel {
	
	/**分页下标-开始位置，从0开始*/
	private Long start;

	/**每页的记录数*/
	private Long limit = 10L;

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
