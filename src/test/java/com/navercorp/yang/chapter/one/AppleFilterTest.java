package com.navercorp.yang.chapter.one;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import com.navercorp.yang.chapter.com.Apple;
import com.navercorp.yang.chapter.com.AppleFilter;

public class AppleFilterTest {

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
	public void testTreditionalWay() {
		List<Apple> resultGreen = AppleFilter.filterGreenApples(inventory);
		assertEquals(3, resultGreen.size());

		List<Apple> resultHeavy = AppleFilter.filterHeavyApples(inventory);
		assertEquals(1, resultHeavy.size());
	}

	@Test
	public void testMethodReference() {
		List<Apple> resultGreen = AppleFilter.filterApples(inventory, Apple::isGreenApple);
		assertEquals(3, resultGreen.size());

		List<Apple> resultHeavy = AppleFilter.filterApples(inventory, Apple::isHeavyApple);
		assertEquals(1, resultHeavy.size());
	}

	@Test
	public void testLamdaStyle() {
		List<Apple> resultGreen = AppleFilter.filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		assertEquals(3, resultGreen.size());

		List<Apple> resultHeavy = AppleFilter.filterApples(inventory, (Apple a) -> 150 < a.getWeight());
		assertEquals(1, resultHeavy.size());
	}

	@Test
	public void testUsingStream() {
		List<Apple> resultGreen = inventory.stream().filter((Apple a) -> "green".equals(a.getColor()))
				.collect(Collectors.toList());
		assertEquals(3, resultGreen.size());

		List<Apple> resultHeavy = inventory.stream().filter((Apple a) -> 150 < a.getWeight())
				.collect(Collectors.toList());
		assertEquals(1, resultHeavy.size());
	}

	private static Apple getApple(String color, int weight) {
		Apple apple = new Apple();
		apple.setColor(color);
		apple.setWeight(weight);
		return apple;
	}
}