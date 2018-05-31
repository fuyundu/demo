package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan // 第一种方法
//@Import(value={SpringUtil.class}) // 引入所有注入的Bean实例 ，第二种方式，本人喜欢第二种，引入法，清晰明了
public class MyApplicationBean {

	// 返回json
	@RequestMapping("/beanHello")
	public String hello2() {
		System.out.println("hhhhhhhhhhhhhhhhh");
		MessagePrinter m = SpringUtil.getBean(MessagePrinter.class);
		m.hello();
		//springUtil2().getBean(MessagePrinter.class).hello();
		return "successed";
	}
	
	 // 第三种方法
//	 @Bean
//     public SpringUtil springUtil2(){return new SpringUtil();}
}
