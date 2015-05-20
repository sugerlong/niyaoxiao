package com.zxl.app.weixin.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zxl.app.weixin.service.TokenWXService;
import com.zxl.app.weixin.util.TokenUrlUtil;



public class TokenUrlServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5001107219465279425L;
	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (TokenUrlUtil.checkSignature(signature, timestamp, nonce)) {
			PrintWriter writer = null;
			try {
				try {
					writer = response.getWriter();
					writer.print(echostr);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} finally {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
			}
		}
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 消息的接收、处理、响应
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = TokenWXService.processRequest(request);
		PrintWriter writer = null;
		try {
			try {
				writer = response.getWriter();
				writer.print(respMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
		
	}
}
