/*
 * @(#)DUserDao.java $version 2017. 8. 9.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Naver
 */
public class DUserDao {
	public Connection getConnection() throws ClassNotFoundException , SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook" , "spring","book");
		return c;
		
	}
}
