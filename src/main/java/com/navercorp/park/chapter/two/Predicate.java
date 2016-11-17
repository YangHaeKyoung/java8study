/*
 * @(#)Predicate.java $version 2016. 11. 17.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

/**
 * @author Naver 추상화
 */
public interface Predicate<T> {
	boolean test(T t);
}
