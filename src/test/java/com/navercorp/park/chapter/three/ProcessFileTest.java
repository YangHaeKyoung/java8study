/*
 * @(#)ProcessFileTest.java $version 2016. 11. 17.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.three;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;

/**
 * @author Naver
 */
public class ProcessFileTest {

	/**
	 * Test method for {@link com.navercorp.park.chapter.three.ProcessFile#processfile()}.
	 * @throws IOException 
	 */
	@Test
	public void testProcessfile() throws IOException {
		//1줄 읽은 예제
		System.out.println(ProcessFile.processfile());		
		System.out.println("====================================================================================");
		//함수인터페이스를 사용함
		System.out.println(ProcessFile.processfile( new TwoLineBufferReaderProcess()));		
		System.out.println("====================================================================================");
		//람다를 이용
		System.out.println(ProcessFile.processfile( (BufferedReader br)-> { return br.readLine() +"\n"+ br.readLine() ;} ));		
		System.out.println("===========================================================");
		
		//fail("Not yet implemented");
	}

}
