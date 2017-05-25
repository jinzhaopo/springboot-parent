package com.jzp.framework.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception e) {

		// 打印异常信息：
		e.printStackTrace();

		System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");

	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DataAccessException.class)
	public @ResponseBody ErrorMessage handleDataAccessException(Exception e) {
		logger.warn(e.getMessage(), e);
		return new ErrorMessage("数据访问错误: " + e.getLocalizedMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(HttpAccessException.class)
	public @ResponseBody ErrorMessage handleHttpAccessException(Exception e) {
		logger.warn(e.getMessage(), e);
		return new ErrorMessage("访问外部服务错误: " + e.getLocalizedMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorMessage handleException(Exception e) {
		logger.warn(e.getMessage(), e);
		return new ErrorMessage("系统内部错误: " + e.getLocalizedMessage());
	}

}
