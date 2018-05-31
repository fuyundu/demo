package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class DemoApplicationTests {

	@Autowired
    private DemoService demoService;
	

	// 测试
	
    @Test
    public void findAllUsers()  {
//        List<User> users = userRepository.findAll();
//        System.out.println(users);
    	
    	
         System.out.println(demoService.findAll().get(0).getName());
         


    }

}
