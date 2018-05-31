package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 主要是@Configuration，实现接口：EnvironmentAware就能获取到系统环境信息;
 *
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware{

	@Value("${spring.datasource.url}")
	private String myUrl;
	
	public void setEnvironment(Environment environment) {
		
		System.out.println(myUrl);
		System.out.println(environment.getProperty("JAVA_HOME"));
	}
}
