package com.jzp.framework.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: ResponseUtil
 * @Description: response工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月25日 下午1:35:24
 */
public class ResponseUtil {
	public static final Logger log = LoggerFactory.getLogger(ResponseUtil.class);

	/**
	 * 直接输出字符串.
	 */
	public static String renderText(String text, HttpServletResponse response) {
		return render(text, "text/plain;charset=UTF-8", response);
	}

	/**
	 * 直接输出字符串GBK编码.
	 */
	public static String renderHtmlGBK(String html, HttpServletResponse response) {
		return render(html, "text/html;charset=GBK", response);
	}

	/**
	 * 直接输出字符串GBK编码.
	 */
	public static String renderHtmlUTF8(String html, HttpServletResponse response) {
		return render(html, "text/html;charset=utf-8", response);
	}

	/**
	 * 直接输出XML.
	 */
	public static String renderXML(String xml, HttpServletResponse response) {
		return render(xml, "text/xml;charset=UTF-8", response);
	}

	/**
	 * 直接输出JSON.
	 */
	public static String renderJSON(String jsonString, HttpServletResponse response) {
		return render(jsonString, "text/json;charset=UTF-8", response);
	}

	/**
	 * 直接输出JSON.
	 */
	public static String renderJSON(Object obj, HttpServletResponse response) {
		return render(JsonUtil.getInstance().obj2json(obj), "text/json;charset=UTF-8", response);
	}

	/**
	 * 绕过Template,直接输出内容的简便函数.
	 */
	public static String render(String text, String contentType, HttpServletResponse response) {
		try {
			response.setContentType(contentType);
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(text);
			response.getWriter().flush();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	// 输出后台 JSON错误消息，返回null
	public static String ajaxJsonErrorMessage(String message, HttpServletResponse response) {
		Error errors = Error.create();
		errors.addErrorString(message);
		return errors.showErrorAjax(response);
	}

	// 输出前台JSON错误消息，返回null
	public static String ajaxJsonFrontErrorMessage(String message, HttpServletResponse response) {
		WebErrors errors = WebErrors.create();
		errors.addErrorString(message);
		return errors.showFrontErrorAjax(response);
	}
}
