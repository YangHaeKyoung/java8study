package com.navercorp.yang.chapter.two;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.BeforeClass;
import org.junit.Test;

import com.navercorp.yang.chapter.one.Apple;

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
		ApplePrint.prettyPrintApple(inventory, Apple::toString);
		ApplePrint.prettyPrintApple(inventory, Apple::toStringSimple);
		ApplePrint.prettyPrintApple(inventory, Apple::toStringMultiLine);
		
		ApplePrint.prettyPrintApple(inventory, (Apple a) -> ToStringBuilder.reflectionToString(a, ToStringStyle.NO_FIELD_NAMES_STYLE));
		ApplePrint.prettyPrintApple(inventory, (Apple a) -> ToStringBuilder.reflectionToString(a, ToStringStyle.SHORT_PREFIX_STYLE));
	}

	private static Apple getApple(String color, int weight) {
		Apple apple = new Apple();
		apple.setColor(color);
		apple.setWeight(weight);
		return apple;
	}
}
