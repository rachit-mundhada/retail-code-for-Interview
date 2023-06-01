package com.demo.retail;

import com.demo.retail.service.RetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest
class RetailApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RetailsServiceImpl retailsService;

	@Test
	void checkIfAmtIsNull(){}
}
