/*
 * @(#)AppleFilterTest.java $version 2016. 11. 16.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.two;

import java.util.ArrayList;
import java.util.List;

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
		
		//Assert.assertEquals("결과가 다르네용!!", 9, resultList.size());
		//Assert.assertEquals("결과가 다르네용!!", 10, resultList.size());
		
		List<Apple> weightAppleList = AppleFilterTest.returnAppleListByWeight(new int[]{100,90,80,1,200,300,400,100});
		AppleFilter.prettyPringApples(weightAppleList, new AppleWeigthFormatter());
		
		System.out.println("======================");
		AppleFilter.prettyPringApples(weightAppleList, new AppleFancyFormatter());
		System.out.println("============================================");
		System.out.println("============================================");
		
		//익명클래스 사용
		AppleFilter.prettyPringApples(weightAppleList, new AppleFormatter(){
			public String accept(Apple e){
				return "This apple is " + e.getWeight() +" kg.";
			}
		});
		System.out.println("======================");
		AppleFilter.prettyPringApples(weightAppleList, new AppleFormatter(){
				public String accept(Apple e){
					if( e.getWeight() > 100 ){
						return "This apple is heavy.";
					}else{
						return "This apple is light.";
					}
				}
		});
		System.out.println("============================================");
		System.out.println("============================================");
		//람다 표현식으로 바꾸기 
		AppleFilter.prettyPringApples(weightAppleList, (Apple e) -> "This apple is " + e.getWeight() +" kg." );
		System.out.println("======================");
		AppleFilter.prettyPringApples(weightAppleList,(Apple e) -> (  e.getWeight() > 100 ? "This apple is heavy." : "This apple is light." ));

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
	static List<Apple> returnAppleListByWeight(int[] weightArray){
		List<Apple> list = new ArrayList<Apple>();
		for( int weight : weightArray){
			Apple e = new Apple();
			e.setWeight(weight);
			list.add(e);
		}
		return list;
		
	}	
	
	//객체초기화 하는 작업
	//@Before 
	
	//@After 테스트후 실행
}
