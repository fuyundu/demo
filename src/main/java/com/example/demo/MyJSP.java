package com.example.demo;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyJSP {

	private String hello = "123";

	// JSP
	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String, Object> map) {
		System.out.println("HelloController.helloJsp().hello=" + hello);
		map.put("hello", hello);
		return "/helloJsp";
	}
    
    /**
     * 返回freemarker-html模板.
     */
    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
       map.put("hello","from TemplateController.helloFtl999999");
       return"/helloFtl";
    }
    
    /**
     * 返回thymeleaf-html模板. 是spring默认模板，不可与jsp模版同时使用
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
       map.put("hello","from TemplateController.helloHtml");
       return "/helloHtml";
    }
}
