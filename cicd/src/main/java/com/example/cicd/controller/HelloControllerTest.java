package com.example.cicd.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest(HelloController.class)
 	class HelloControllerTest {
	
	@Autowired
	
	private MockMvc mockMvc;
	
	@Test
	
	void helloReturnsMessage() throws Exception {

		mockMvc.perform(get("/api/hello"))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith("application/json"))
		.andExpect(jsonPath("$.message", containsString("GitHub Actions成功")));

	}
}
