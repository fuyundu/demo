package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReadProperties {
	
	@Autowired
	private Wisely2Settings wisely2Settings;
	
	@Autowired
	private User user;
	
	@RequestMapping("/testReadPropertes")
	@ResponseBody // 此处得加上@ResponseBody，要不加的话就默认寻找模板去的，找jsp或者你自己定义的模板，因为类上面加的是@Controller，要是加@RestController就不用加下面的@ResponseBody
	public String test() {
		return wisely2Settings.getName()+":"+user.getName();
	}
}
