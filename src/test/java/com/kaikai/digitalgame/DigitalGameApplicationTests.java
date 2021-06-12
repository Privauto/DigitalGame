package com.kaikai.digitalgame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DigitalGameApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	//16选1
	public  void getChaos() {
		int blueball=getChaosCoefficient(16);
		System.out.println(blueball);
	}
	
	public static Integer getChaosCoefficient(int number) {
		Integer coefficient = 0;
		if(number==16) {
			coefficient=(int)(Math.random()*16+1);
		}
		return coefficient;
	}
	
}
