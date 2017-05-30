package com.jzp.framework.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.jzp.framework.freemarker.FreemarkerStaticModels;
import com.jzp.framework.freemarker.directive.FlashMessageDirective;
import com.jzp.framework.freemarker.method.MessageMethod;
import com.jzp.framework.properties.FreemarkerProperties;
import com.jzp.framework.util.ApplicationContext;

/**
 * 
 * @ClassName: FreemarkerConfig
 * @Description: freemarker 配置文件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月30日 下午8:58:46
 */
@Configuration
public class FreemarkerConfig {
	@Autowired
	private FreemarkerProperties freemarkerProperties;
	@Autowired
	private FlashMessageDirective flashMessageDirective;
	@Autowired
	private MessageMethod messageMethod;

	/**
	 * 
	 * @Title: getFreeMarkerConfigurer
	 * @Description: freemarker 配置
	 * @return
	 * @return: FreeMarkerConfigurer
	 */
	@Bean(name = "freeMarkerConfigurer")
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		FreeMarkerConfigurer fmcf = new FreeMarkerConfigurer();
		fmcf.setTemplateLoaderPath(freemarkerProperties.getLoader_path());

		Properties settings = new Properties();
		settings.setProperty("defaultEncoding", freemarkerProperties.getEncoding());
		settings.setProperty("url_escaping_charset", freemarkerProperties.getUrl_escaping_charset());
		settings.setProperty("locale", freemarkerProperties.getLocale());
		settings.setProperty("template_update_delay", freemarkerProperties.getLocale());
		settings.setProperty("tag_syntax", "auto_detect");
		settings.setProperty("whitespace_stripping", "true");
		settings.setProperty("classic_compatible", "true");
		settings.setProperty("number_format", freemarkerProperties.getNumber_format());
		settings.setProperty("boolean_format", freemarkerProperties.getBoolean_format());
		settings.setProperty("datetime_format", freemarkerProperties.getDatetime_format());
		settings.setProperty("date_format", freemarkerProperties.getDate_format());
		settings.setProperty("time_format", freemarkerProperties.getTime_format());
		settings.setProperty("auto_import", freemarkerProperties.getAuto_import());
		settings.setProperty("object_wrapper", "freemarker.ext.beans.BeansWrapper");
		fmcf.setFreemarkerSettings(settings);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("base", ApplicationContext.getContentPath());
		variables.put("locale", freemarkerProperties.getLocale());
		variables.put("message", messageMethod);
		variables.put("flash_message", flashMessageDirective);
		fmcf.setFreemarkerVariables(variables);
		return fmcf;
	}


	@Bean(name="freemarkerStaticModels")
	public FreemarkerStaticModels getFreemarkerStaticModels() {
		FreemarkerStaticModels instance = FreemarkerStaticModels.getInstance();
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		
		Properties properties = new Properties();
		
		
		propertiesFactoryBean.setProperties(properties);
		
		//instance.setStaticModels(staticModels);
		return null;
	}
}
