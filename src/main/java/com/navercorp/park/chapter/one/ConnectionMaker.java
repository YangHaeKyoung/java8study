/*
 * @(#)ConnectionMaker.java $version 2017. 8. 9.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.one;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Naver
 */
public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException , SQLException;
}
