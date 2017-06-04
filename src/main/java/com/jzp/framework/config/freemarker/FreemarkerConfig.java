
package com.jzp.framework.config.freemarker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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

	@Autowired
	private FreeMarkerProperties freeMarkerProperties;

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

		writerProperties(fmcf);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("base", ApplicationContext.getContentPath());
		variables.put("locale", freemarkerProperties.getLocale());
		variables.put("message", messageMethod);
		variables.put("flash_message", flashMessageDirective);
		fmcf.setFreemarkerVariables(variables);
		return fmcf;
	}
	
	@Bean(name = "freemarkerStaticModels")
	public FreemarkerStaticModels getFreemarkerStaticModels() {
		FreemarkerStaticModels instance = FreemarkerStaticModels.getInstance();

		PropertiesFactoryBean pfb = new PropertiesFactoryBean();
		Resource resource = new ClassPathResource("freemarkerstatic.properties");
		pfb.setLocation(resource);

		try {
			instance.setStaticModels(pfb.getObject());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * 
	 * @Title: writerProperties
	 * @Description: 将springboot中的freemarkerProperity配置给设置到自己的本地中
	 * @param factory
	 * @return: void
	 */
	private void writerProperties(FreeMarkerConfigurer factory) {
		factory.setTemplateLoaderPaths(this.freeMarkerProperties.getTemplateLoaderPath());
		factory.setPreferFileSystemAccess(this.freeMarkerProperties.isPreferFileSystemAccess());
		factory.setDefaultEncoding(this.freeMarkerProperties.getCharsetName());

		Properties settings = new Properties();
		settings.putAll(this.freeMarkerProperties.getSettings());
		

		factory.setFreemarkerSettings(settings);
	}
}
