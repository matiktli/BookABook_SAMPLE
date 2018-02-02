package com;

import com.configuration.MvcConfiguration;
import com.controllers.WelcomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfiguration.class, BookABookApp.class})
@WebAppConfiguration
public class WelcomeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @InjectMocks
    private WelcomeController welcomeController = new WelcomeController();


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.wac)
                .build();
    }

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("welcomePage"));
    }
}
