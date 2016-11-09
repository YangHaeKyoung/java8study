package com.navercorp.yang.chapter.two;

import java.util.List;
import java.util.function.Function;

import com.navercorp.yang.chapter.one.Apple;

/**
 * chapter2 ДыБо2-1
 * @author Naver
 *
 */
public class ApplePrint {

	public static void prettyPrintApple(List<Apple> inventory, Function<Apple, String> f) {
		for (Apple apple : inventory) {
			String output = f.apply(apple);
			System.out.println(output);
		}
	}
}
