package com.jzp.framework.mvc;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * 
 * @ClassName: Error
 * @Description: 错误<br/>
 *               这个是 用来做错误拦截的
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月25日 上午9:31:07
 */
public class WebError {

	private List<String> errors;

	/**
	 * 通过HttpServletRequest创建error
	 * 
	 * @param request
	 *            从request中获得MessageSource和Locale，如果存在的话。
	 * @return 如果LocaleResolver存在则返回国际化WebErrors
	 */
	public static WebError create() {
		return new WebError();
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
