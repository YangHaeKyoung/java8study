/*
 * @(#)AppleFilterTest.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Naver
 */
public class AppleFilterTest {

	/**
	 * Test method for {@link com.navercorp.park.chapter.two.AppleFilter#fillterGreenAppples(java.util.List)}.
	 */
	@Test
	public void testFillterGreenAppples() {
		
		List<Apple> inventory = AppleFilterTest.returnAppleListByColor(new String[]{"green","green","red","green","green","blue","green","green","black","yellow","green","green","green","green"});		
		List<Apple> resultList = AppleFilter.fillterGreenAppples(inventory);
		
		Assert.assertEquals("결과가 다르네용!!", 9, resultList.size());
		Assert.assertEquals("결과가 다르네용!!", 10, resultList.size());
		
		//assetEquals
		//assetArrayEqulas
		//assetSame()//동일 객체 확인
		//assetTrue(a)
		//assetNotNull(a)
	}
	
	static List<Apple> returnAppleListByColor(String[] colorArry){
		List<Apple> list = new ArrayList<Apple>();
		for( String color : colorArry){
			Apple e = new Apple();
			e.setColor(color);
			list.add(e);
		}
		return list;
		
	}	
	//객체초기화 하는 작업
	//@Before 
	
	//@After 테스트후 실행
}
