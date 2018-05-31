package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 要想拦截器起作用就得注掉
 @Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer{
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
       
		// 当程序不无解析时，可以先mvn clean,再 build
		/*
		最后强调一点：只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的，
		比如我们自定义的Servlet地址http://localhost:8080/myServlet1 是不会被拦截器拦截的。
		并且不管是属于哪个Servlet 只要复合过滤器的过滤规则，过滤器都会拦截。

		最后说明下，我们上面用到的 WebMvcConfigurerAdapter 并非只是注册添加拦截器使用，
		其顾名思义是做Web配置用的，它还可以有很多其他作用，通过下面截图便可以大概了解，
		具体每个方法都是干什么用的，留给大家自己研究（其实都大同小异也很简单）。 */
		
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
    }
  
}
