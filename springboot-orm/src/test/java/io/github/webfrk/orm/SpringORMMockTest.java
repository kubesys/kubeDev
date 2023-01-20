/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.webfrk.orm;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


/**
 * @author wuheng@iscas.ac.cn
 * @since  2019.11.16
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringORMBootServer.class)
@AutoConfigureMockMvc
class SpringORMMockTest  {

	
	@Autowired
	private MockMvc mvc;

	//-----------------------------------------------------------------------
	final static String VALID_POST_REQUEST_PATH = "/user/createUser";
	
	@Test
	void testValidPostObjParameterBody() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post(VALID_POST_REQUEST_PATH)
				.content("{ \"user\": { \"name\": \"wuheng\", \"email\": \"wuheng@otcaix.iscas.ac.cn\" }}")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("code").value(20000));
	}
	
}