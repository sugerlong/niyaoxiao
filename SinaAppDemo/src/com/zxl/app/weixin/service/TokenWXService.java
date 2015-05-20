package com.zxl.app.weixin.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.zxl.app.model.Xiao_Hua;
import com.zxl.app.service.BackService;
import com.zxl.app.weixin.model.MessageModel;
import com.zxl.app.weixin.respond.Article;
import com.zxl.app.weixin.respond.NewsMessage;
import com.zxl.app.weixin.respond.TextMessage;
import com.zxl.app.weixin.util.MessageUtil;



public class TokenWXService {
	/**
	 * 处理微信发来的请求
	 * @param request
	 */
	
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			

			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {// 文本消息
				respMessage = responseResultText(textMessage,fromUserName,toUserName ,requestMap);
			}else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){// 图片消息
				respMessage = responseResultImage(textMessage,fromUserName,toUserName);
			}else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){// 地理位置消息
				respMessage = responseResultLocation(textMessage,fromUserName,toUserName);
			}else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {// 链接消息
				respMessage = responseResultLink(textMessage,fromUserName,toUserName);
			}else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {// 音频消息
				respMessage = responseResultVoice(textMessage,fromUserName,toUserName);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respMessage = responseResultRubscribe(textMessage,fromUserName,toUserName);
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					respMessage = responseResultDiyEvent(textMessage,fromUserName,toUserName,requestMap);
				}
				// 取消订阅
//				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//				}
                 
			}
			if(StringUtils.isEmpty(respMessage)){
				// 默认回复此文本消息
				respMessage = defaultResultMessage(textMessage,fromUserName,toUserName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
	// 默认回复此文本消息
	public static String defaultResultMessage(TextMessage textMessage,String fromUserName,String toUserName){
		MessageModel mm = new MessageModel();
		mm.setKeyCode("DefuntMessage");
		return findMessageByKeyCode(textMessage,fromUserName,toUserName,mm);
	}
	// 处理  请求消息类型：文本 
	public static String responseResultText(TextMessage textMessage,String fromUserName,String toUserName ,Map<String, String> requestMap){
//		textMessage.setContent("您发送的是文本消息");
		String content = requestMap.get("Content");//接受消息内容
		textMessage.setContent(addXh(content));
		return  MessageUtil.textMessageToXml(textMessage);
	}
	// 处理  请求消息类型：图片
	public static String responseResultImage(TextMessage textMessage,String fromUserName,String toUserName){
		// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义
//		textMessage.setContent("您发送的是图片消息，暂时不支持图片哦！换个方式试下");
		textMessage.setContent("你不笑我的错，服务正在创建中...敬请期待");
		return  MessageUtil.textMessageToXml(textMessage);
	}
	// 处理  请求消息类型：地理位置 
	public static String responseResultLocation(TextMessage textMessage,String fromUserName,String toUserName){
//		textMessage.setContent("您发送的是地理位置消息，暂时不支持地理位置消息哦！换个方式试下");
		textMessage.setContent("你不笑我的错，服务正在创建中...敬请期待");
		return  MessageUtil.textMessageToXml(textMessage);
	}
	// 处理  请求消息类型：链接
	public static String responseResultLink(TextMessage textMessage,String fromUserName,String toUserName){
//		textMessage.setContent("您发送的是链接消息，暂时不支持链接消息哦！换个方式试下");
		textMessage.setContent("你不笑我的错，服务正在创建中...敬请期待");
		return  MessageUtil.textMessageToXml(textMessage);
	}
	// 处理  请求消息类型：图片
	public static String responseResultVoice(TextMessage textMessage,String fromUserName,String toUserName){
//		textMessage.setContent("您发送的是音频消息，暂时不支持音频消息哦！换个方式试下");
		textMessage.setContent("你不笑我的错，服务正在创建中...敬请期待");
		return  MessageUtil.textMessageToXml(textMessage);
	}
	// 处理  某个用户订阅（关注）后的自动回复的信息
	public static String responseResultRubscribe(TextMessage textMessage,String fromUserName,String toUserName){
		MessageModel mm = new MessageModel();
		mm.setKeyCode("用户关注");
		return findMessageByKeyCode(textMessage,fromUserName,toUserName,mm);
	}
	// 处理  自定义事件
	public static String responseResultDiyEvent(TextMessage textMessage,String fromUserName,String toUserName,Map<String, String> requestMap){
		// 事件KEY值，与创建自定义菜单时指定的KEY值对应
		String eventKey = requestMap.get("EventKey");
		MessageModel mm = new MessageModel();
		mm.setKeyCode(eventKey);
		return findMessageByKeyCode(textMessage,fromUserName,toUserName,mm);
	}
	//调用接口查询信息
	public static String findMessageByKeyCode(TextMessage textMessage,String fromUserName,String toUserName,MessageModel mm){
		String respMessage = null;
		List<MessageModel> mmList = new ArrayList<MessageModel>();
		try {
			try {
//				mmList = IdcClient.getInstance().getResumeService().findMessageByKeyCode(mm);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null!=mmList&&mmList.size()>0){
				MessageModel m = mmList.get(0);
				if(null!=m&&StringUtils.isNotEmpty(m.getMessageType())){
					if(m.getMessageType().equals("图文")){
						respMessage = initNewsImageMessage(m,fromUserName,toUserName);
					}else{
						textMessage.setContent(m.getDescription());
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				}
			}else{
				textMessage.setContent("你不笑我的错，谢谢您的关注");
				respMessage =   MessageUtil.textMessageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
//	//调用接口查询简历
//	public static List<ResumeVo> findResumeByResumeVo(ResumeVo vo){
//		List<ResumeVo> rList = null;
//		try {
//			rList = IdcClient.getInstance().getResumeService().findResumeByResumeVo(vo);
//		} catch (Exception e) {
//			logger.info("查询简历出错，错误码：" + e);
//		}
//		return rList;
//	}
	//初始化图文信息
	public static String initNewsImageMessage(MessageModel mm,String fromUserName,String toUserName){
		// 创建图文消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
		article.setTitle(mm.getTitle());
		article.setDescription(mm.getDescription());
		article.setPicUrl(mm.getPicUrl());
		article.setUrl(mm.getLinkUrl());
		articleList.add(article);
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		return MessageUtil.newsMessageToXml(newsMessage);
	}
	//调用接口返回多条信息
	public static String findManyMessageByKeyCode(TextMessage textMessage,String fromUserName,String toUserName,MessageModel mm){
		String respMessage = null;
		List<MessageModel> mmList = new ArrayList<MessageModel>();
		try {
			try {
//				mmList = IdcClient.getInstance().getResumeService().findMessageByKeyCode(mm);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null!=mmList&&mmList.size()>0){
				respMessage = initManyNewsImageMessage(mmList,fromUserName,toUserName);
			}else{
				textMessage.setContent("你不笑我的错，谢谢您的关注");
				respMessage =   MessageUtil.textMessageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
	//初始化图文信息
	public static String initManyNewsImageMessage(List<MessageModel> mmList,String fromUserName,String toUserName){
		// 创建图文消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
		List<Article> articleList = new ArrayList<Article>();
		if(null!=mmList&&mmList.size()>0){
			for(MessageModel mm:mmList){
				Article article = new Article();
				article.setTitle(mm.getTitle());
				article.setDescription("");
				article.setPicUrl(mm.getPicUrl());
				article.setUrl(mm.getLinkUrl());
				articleList.add(article);
			}
		}
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		return MessageUtil.newsMessageToXml(newsMessage);
	}
	//初始化图文信息
	public static String addXh(String content){
		 WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
         // 获取URL请求记录service
		 BackService backService = (BackService) webApplicationContext.getBean("backService");
		 String mseeage = "你不笑我的错，服务正在创建中...敬请期待";
		 if(null!=backService){
			 if(content.contains("#新增#")){//正确完整格式为#新增#标题+内容
				 String os[] = content.split("[#]");
				 try {
					 if(os.length==3){
						 if(StringUtils.isNotEmpty(os[1])&&os[1].equals("新增")){
							 String xiaohua = os[2];//接受消息内容
							 if(StringUtils.isNotEmpty(os[2])){
								 String xiaohuaS[] = xiaohua.split("[+]");
								 if(xiaohuaS.length==2){
									 if(StringUtils.isNotEmpty(xiaohuaS[0])&&StringUtils.isNotEmpty(xiaohuaS[1])&&xiaohuaS[0].length()<50){
										 Xiao_Hua xiaoHua = new Xiao_Hua();
										 xiaoHua.setTitle(xiaohuaS[0]);
										 xiaoHua.setContent(xiaohuaS[1]);
										 try {
											backService.addXiaoHua(xiaoHua);
											 mseeage = "创建成功";
										} catch (Exception e) {
											 mseeage = "创建失败";
										}
									 }else{
										 mseeage = "你输入的格式不正确，请按照 #新增#标题+内容  来进行创建"; 
									 }
								 }else{
									 mseeage = "你输入的格式不正确，请按照 #新增#标题+内容  来进行创建"; 
								 }
							 }
						 }else{
							 mseeage = "你输入的格式不正确，请按照 #新增#标题+内容  来进行创建"; 
						 }
					 }else{
						 mseeage = "你输入的格式不正确，请按照 #新增#标题+内容  来进行创建"; 
					 }
				} catch (Exception e) {
					mseeage = "你不笑我的错，服务正在创建中...敬请期待";
				}
			}
		 }
		
		return mseeage;
	}
	
	
}