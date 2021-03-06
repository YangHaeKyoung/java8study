/*
 * @(#)TwoLineBufferReaderProcess.java $version 2016. 11. 17.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.three;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Naver
 */
public class TwoLineBufferReaderProcess implements BufferReaderProcessor{
	public String process(BufferedReader br) throws IOException{
		return br.readLine() +"\n"+ br.readLine();
		
	}

}
