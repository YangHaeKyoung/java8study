package com.navercorp.yang.chapter.two;

import java.util.List;
import java.util.function.Function;

import com.navercorp.yang.basic.model.Apple;

/**
 * chapter2 ����2-1
 * @author Naver
 *
 */
public class ApplePrint {

	public static void prettyPrintAppleUseFunction(List<Apple> inventory, Function<Apple, String> f) {
		for (Apple apple : inventory) {
			String output = f.apply(apple);      
			System.out.println(output);
		}
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
		for (Apple apple : inventory ) {
			String output = formatter.accept(apple);
			System.out.println(output);
		}		
	}
}