/*
 * @(#)AppleColorPredicate.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

/**
 * @author Naver
 */
public class AppleColorPredicate implements ApplePredicate{
	public boolean test(Apple apple){
		return "green".equals(apple.getColor());
	}

}
