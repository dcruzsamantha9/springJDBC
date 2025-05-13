package com.practice.spring_mongo.BankingAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BankingApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
