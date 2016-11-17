/*
 * @(#)Filter.java $version 2016. 11. 17.
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
public class Filter {
	public static <T> List<T> filter( List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for( T e : list){
			if(p.test(e)) result.add(e);
		}
		return result;
	}
}
