package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestRestfull {
    
	@Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;
 
    @Before
    public void  setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }
 
    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getDemo")//访问/user接口
               .param("username","admin")//访问的参数username值为admin
               .contentType(MediaType.APPLICATION_JSON_UTF8))//使用json utf-8
               .andExpect(MockMvcResultMatchers.status().isOk())//返回的状态是200
               .andDo(MockMvcResultHandlers.print())  // 打印请求和响应信息
               .andReturn();  
    }
}