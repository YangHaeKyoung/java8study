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
	public static List<Apple> fillterGreenAppples(List<Apple> inventory){
		List<Apple> result= new ArrayList<>();
		for(Apple apple : inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	
}
