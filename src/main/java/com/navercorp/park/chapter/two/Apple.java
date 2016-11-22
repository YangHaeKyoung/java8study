/*
 * @(#)Apple.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

/**
 * @author Naver
 */
public class Apple {
	String color;
	int weight;
	
	public String getColor(){
		return color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setColor(String color){
		this.color = color;
	}
}
