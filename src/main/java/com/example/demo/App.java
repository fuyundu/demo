package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

// http://127.0.0.1:9090/druid/index.html 访问查看sql监控
@ComponentScan(basePackages= {"com.example.demo", "com.other"}) // Spring Boot默认会扫描启动类同包以及子包下的注解,若要扫其它的包得需要指定，如若指定默认就不会扫启动类的包了，所以也得同时指定。
@SpringBootApplication
@ServletComponentScan // 此注解必须加在这，要不不好用， 扫描带@WebServlet, @WebFilter, @WebListener注解的servlet,要不就得以@bean的方式注入
@EnableConfigurationProperties(Wisely2Settings.class) // 设置启用vo类中配置的@ConfigurationProperties
public class App {

	/*
	 * MyRestful restful风格
	 * SchedulingConfig 定时
	 * MyJSP 返回jsp模板和freemarker模板
	 * @ServletComponentScan 让sevlet、过滤器和监听器生效
	 * SpringJDBCDao  SpringJDBC
	 * DemoRepository JPA
	 * SpringUtil 引入Application实例
	 * JacksonTester json转java类，java类传json
	 * MyStartupRunner1 启动的时候就去加载一些数据
	 * MyWebAppConfigurer 拦截器
	 * DemoApplicationTests 测试类,在下面的测试包中
	 * ReadProperties 读取properties文件
	 * 
     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
     *
     * 加入servlet有两种方式1、@Bean。2、在servlet类上加@WebServlet在应用程序入口上加@ServletComponentScan
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//    	
//    	 // FilterRegistrationBean 过滤器
//    	 // ServletListenerRegistrationBean 监听器
//    	
//        return new ServletRegistrationBean(new MyServlet(), "/xs/*");// ServletName默认值为首字母小写，即myServlet 请求路径为：http://localhost:9090/xs/myservlet
//    }
//    
//    @Bean // 感觉过
//    public FilterRegistrationBean testFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new MyFilterTime());
//        
//       //过滤掉 /hell/dufuyun 和/hello 的请求，测试后也没过滤掉啊。
//       //  registration.addUrlPatterns("/hell/dufuyun","/hello");
//        
//        // 添加过滤规则.  过滤器会过滤掉所有的请求。无论是servlet还是用@Controller注解的@RequestMapping请求
//        // /list/yy/ 过滤这个请求路径下所有请求
//        registration.addUrlPatterns("/list/yy/*");  
//        
//        // 添加忽略的格式信息.  
//        registration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");  
//        
//        //过滤所有请求
//        // registration.addUrlPatterns("/*");
//        registration.setName("MyFilterTime");
//        registration.setOrder(1);
//        return registration;
//    }
    
    /**
     * 修改DispatcherServlet默认配置，目前不知道干啥用先放在这
     * 
     * @param dispatcherServlet
     * @return
     
     */
//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//        registration.getUrlMappings().clear();
//        registration.addUrlMappings("*.do");
//        registration.addUrlMappings("*.json");
//        return registration;
//    }
	
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
	}
}
