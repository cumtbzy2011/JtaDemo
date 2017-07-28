package com.bian.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.bi on 2016/9/27.
 * bean获取工具类
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	private static String logPath;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> c){
		return applicationContext.getBean(c);
	}

	public static String getLogPath(){
		if (logPath == null){
			Environment environment = getBean(Environment.class);
			logPath = environment.getProperty("logging.path");
		}
		return logPath;
	}
}
