/*
 * @(#)AppleFancyFormatter.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

/**
 * @author Naver
 */
public class AppleFancyFormatter implements AppleFormatter{
	public String accept(Apple e){
		if( e.getWeight() > 100 ){
			return "This apple is heavy.";
		}else{
			return "This apple is light.";
		}
	}

}
