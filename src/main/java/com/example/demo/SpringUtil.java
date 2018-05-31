package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*
 * 有三种方式可以加载ApplicationContext 
 * 1、在实现了ApplicationContextAware的类加 @Component 在使用类加入@ComponentScan
 * 2、@Import(value={SpringUtil.class}) // 第二种方式
 * 3、 
 * @Bean
    public SpringUtil springUtil2(){
    	return new SpringUtil();
    }
    第一种在本类操作，后两种在主程序类操作,不要加三种方法一起使用，否则会加载多次。虽然是单例，但也不要加载多次没意义。spring5.0已经不用加入application.xml了。
 * */


@Component // 第一种方式
public class SpringUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringUtil.applicationContext = applicationContext;
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------");
		System.out.println(
				"---------------com.kfit.base.util.SpringUtil------------------------------------------------------");
		System.out.println(
				"========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+ SpringUtil.applicationContext + "========");
		System.out.println("---------------------------------------------------------------------");
	}

	// 获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	// 通过name获取 Bean.
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	// 通过class获取Bean.
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	// 通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}
}
