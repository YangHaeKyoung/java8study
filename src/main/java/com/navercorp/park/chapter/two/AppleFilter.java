/*
 * @(#)AppleFilter.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Naver
 */
public class AppleFilter {
	//녹색사과 필터
	public static List<Apple> fillterGreenAppples(List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple apple : inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	//색을 파라미터화 
	public static List<Apple> fillterGreenAppplesByColor(List<Apple> inventory , String color){
		List<Apple> result= new ArrayList<>();
		for(Apple apple : inventory){
			if(color.equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	//무게로 리턴
	public static List<Apple> fillterGreenAppplesByColor(List<Apple> inventory , int weight){
		List<Apple> result= new ArrayList<>();
		for(Apple apple : inventory){
			if(apple.getWeight()> weight){
				result.add(apple);
			}
		}
		return result;
	}
	
	//추상적인 조건으로 리턴
	public static List<Apple> fillterAppples(List<Apple> inventory , ApplePredicate p){
		List<Apple> result= new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
}
