package com.navercorp.yang.chapter.two;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.navercorp.yang.basic.model.Apple;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ApplePrintTest {
	private static List<Apple> inventory;

	@BeforeClass
	public static void befor() {
		inventory = new ArrayList<>();
		
		inventory.add(getApple("green", 170));
		inventory.add(getApple("red", 100));
		inventory.add(getApple("yellow", 150));
		inventory.add(getApple("green", 130));
		inventory.add(getApple("green", 150));
	}
	
	@Test
	public void test() {
		
		ApplePrint.prettyPrintApple(inventory, new AppleFancyFormatter());
	}
	
	private static Apple getApple(String color, int weight) {
		Apple apple = new Apple();
		apple.setColor(color);
		apple.setWeight(weight);
		return apple;
	}
}