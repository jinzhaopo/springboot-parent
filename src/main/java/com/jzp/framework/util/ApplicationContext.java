package com.jzp.framework.util;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @ClassName: ApplicationContext
 * @Description: 项目上下文
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月25日 上午11:25:10
 */
@Component
public class ApplicationContext implements ServletContextAware {

	private static ServletContext servletContext;

	/**
	 * 
	 * @Title: getSessionAttr
	 * @Description: 根据key获取session中的value
	 * @param key
	 * @return
	 * @return: Object
	 */
	public static Object getSessionAttr(String key) {
		HttpSession session = RequestUtil.getRequest().getSession(false);
		if (session == null) {
			return null;
		} else {
			return session.getAttribute(key);
		}
	}

	/**
	 * 
	 * @Title: getCookie
	 * @Description: 根据name获取cookie
	 * @param name
	 * @return
	 * @return: Cookie
	 */
	public static Cookie getCookie(String name) {
		Cookie[] cookies = RequestUtil.getRequest().getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: getSessionId
	 * @Description: 获取sessionid
	 * @param isCreate
	 * @return
	 * @return: String
	 */
	public static String getSessionId(boolean isCreate) {
		HttpSession session = RequestUtil.getRequest().getSession(isCreate);
		if (session == null) {
			return null;
		} else {
			return session.getId();
		}
	}

	/**
	 * 
	 * @Title: setSessionAttr
	 * @Description: key-value设置到session中
	 * @param key
	 * @param value
	 * @return: void
	 */
	public static void setSessionAttr(String key, Object value) {
		HttpSession session = RequestUtil.getRequest().getSession(false);
		if (session == null) {
			session = RequestUtil.getRequest().getSession(true);
		}
		session.setAttribute(key, value);
	}

	/**
	 * 
	 * @Title: removeAttribute
	 * @Description: 根据key移除session中的值
	 * @param key
	 * @return: void
	 */
	public static void removeAttribute(String key) {
		HttpSession session = RequestUtil.getRequest().getSession(false);
		session.removeAttribute(key);
	}

	/**
	 * 
	 * @Title: getAppRealPath
	 * @Description: 获取真实路径
	 * @param path
	 * @return
	 * @return: String
	 */
	public static String getAppRealPath(String path) {
		return servletContext.getRealPath(path);
	}
	/**
	 * 
	 * @Title: getContentPath
	 * @Description: 获取相对路径
	 * @return
	 * @return: String
	 */
	public static String getContentPath(){
		return servletContext.getContextPath();
	}
	
	

	/* get and set */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	/**
	 * 
	 * @Title: getContext
	 * @Description: 获取上下问
	 * @return
	 * @return: ServletContext
	 */
	public static ServletContext getContext() {
		return servletContext;
	}

}
