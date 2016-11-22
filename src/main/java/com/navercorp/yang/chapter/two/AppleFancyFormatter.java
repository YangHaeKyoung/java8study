package com.navercorp.yang.chapter.two;

import com.navercorp.yang.basic.model.Apple;

public class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
		return "A " + characteristic + " " + apple.getColor() + " apple";
	}
}