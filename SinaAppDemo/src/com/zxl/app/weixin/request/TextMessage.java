package com.zxl.app.weixin.request;


public class TextMessage extends BaseQeqMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
