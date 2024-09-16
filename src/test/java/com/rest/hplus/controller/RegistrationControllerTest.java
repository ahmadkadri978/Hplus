package com.rest.hplus.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testRegisterUser() throws Exception {
		String requestBody = "username=testuser&password=password&first_name=John&last_name=Doe&activity=sport&gender=MALE&age=1999-01-01";

		mockMvc.perform(MockMvcRequestBuilders.post("/registeruser")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection()) // Assuming you redirect after successful registration
				.andExpect(MockMvcResultMatchers.redirectedUrl("/goToLogin"));
	}
}

