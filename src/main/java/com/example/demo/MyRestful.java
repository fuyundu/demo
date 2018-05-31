package com.example.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController // 注意：controller注解不能使用@RestController，要用@Controller，因为@RestController =@Controller+@ResponeBody，会直接返回josn数据
public class MyRestful {
	
	@Resource
	private DemoService demoService;
	
	@Autowired
	private Wisely2Settings wisely2Settings;
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println(wisely2Settings.getName()+": "+wisely2Settings.getGender());
		return "Hello world!";
	}
	
	@RequestMapping("/getUser")
	public String getUser() {
		return "Hello world getUser!";
	}
	
	// 返回json
	@RequestMapping("/getDemo")
	public Demo getDemo() {
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("Angel");
		return demo;
	}

	// 返回json
	@RequestMapping("/hello/{id}")
	public Demo hello5(@PathVariable Long id) {
		Demo demo = demoService.getByIdSpringJdbc(id);
		return demo;
	}
}
