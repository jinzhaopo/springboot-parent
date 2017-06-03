package com.jzp.framework.service.impl;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.jzp.framework.service.MyCaptchaService;
import com.octo.captcha.service.CaptchaService;

/**
 * 
 * @ClassName: CaptchaServiceImpl
 * @Description: 验证码
 * @author: zhaopo
 * @date: 2016年11月4日 上午11:03:55
 */
@Service
public class CaptchaServiceImpl implements MyCaptchaService {

	@Resource
	private CaptchaService imageCaptchaService;

	/**
	 * 
	 * @Title: buildImage
	 * @Description: 创建验证码图片
	 * @param captchaId
	 * @return
	 * @see com.gaiya.ceo.service.MyCaptchaService#buildImage(java.lang.String)
	 */
	public BufferedImage buildImage(String captchaId) {
		return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
	}

	/**
	 * 
	 * @Title: isValid
	 * @Description: 验证验证码
	 * @param captchaId
	 * @param captcha
	 * @return
	 * @see com.gaiya.ceo.service.MyCaptchaService#isValid(java.lang.String,
	 *      java.lang.String)
	 */
	public boolean isValid(String captchaId, String captcha) {
		if (!StringUtils.isNotEmpty(captchaId) || !StringUtils.isNotEmpty(captcha)) {
			return false;
		}
		try {
			return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase()).booleanValue();
		} catch (Exception e) {
			return false;
		}
	}
}
