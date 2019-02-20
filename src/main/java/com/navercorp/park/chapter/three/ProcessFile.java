/*
 * @(#)ProcessFile.java $version 2016. 11. 17.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Naver
 */
public class ProcessFile {
	//처음 기능구현
	public static String processfile() throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\aaa.txt"))){
			return br.readLine();
		}
		
	}
	
	//함수인터페이스로 표현
	public static String processfile(BufferReaderProcessor b ) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\aaa.txt"))){
			return b.process(br);
		}
		
	}
	public static void main(String[] args){
		//int coin = (int) Math.ceil( 74194/1000 ) * 1000;
		//int coin = (int) Math.ceil(  (float) 74194/1000  )*1000;
		int coin = (int) Math.ceil(  74194f/1000  )*1000;
		System.out.println("coin===" + coin);
		
		System.out.println("coin===" + Math.ceil( (float) (74194/1000) ) * 1000 );
		System.out.println("coin===" + Math.ceil( 74194/100 )*100  );
		System.out.println("coin===" + Math.ceil( 74194/1000)  );
		System.out.println("coin===" +(  (float) 74194/1000  ));
		System.out.println("coin===" +Math.ceil(  (float) 74194/1000  )*1000);
		
	}
	
}
