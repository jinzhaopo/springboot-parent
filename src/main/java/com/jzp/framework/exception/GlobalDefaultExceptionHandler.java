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

	/**
	 * 
	 * @Title: defaultErrorHandler
	 * @Description: 数据库异常
	 * @param req
	 * @param e
	 * @return: void
	 */
	@ExceptionHandler(value = SQLException.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception e) {
		logger.error(e.getMessage());
	}

}
