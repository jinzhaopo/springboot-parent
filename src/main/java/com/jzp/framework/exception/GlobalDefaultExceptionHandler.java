package com.jzp.framework.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @ClassName: GlobalDefaultExceptionHandler
 * @Description: 全局默认的异常捕获信息
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月24日 下午3:04:54
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception e) {

		// 打印异常信息：

		e.printStackTrace();

		System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");

	}

}
