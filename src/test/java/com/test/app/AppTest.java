package com.test.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

	@Before
	public void before() throws Exception {
		System.out.println("before");
	}

	@After
	public void after() throws Exception {
		System.out.println("after");
	}
	
	@Test
	public void test(){
		assertThat(true).isEqualTo(true);		
	}

}
