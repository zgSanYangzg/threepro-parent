package cn.three.module.hello.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@SpringBootApplication
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 4
    }
    @Test
    public void indexText() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andReturn();
        int status = mvcResult.getResponse().getStatus(); // 6
        String responseString = mvcResult.getResponse().getContentAsString(); // 7

        Assert.assertEquals("return status not equals 200", 200, status); // 8
        Assert.assertEquals("response string not equalse ", "Hello", responseString); // 9




    }
}
