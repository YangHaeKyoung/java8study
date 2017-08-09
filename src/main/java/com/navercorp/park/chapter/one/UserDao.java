/*
 * @(#)UserDao.java $version 2017. 8. 9.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.navercorp.park.chapter.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Naver
 */
public class UserDao {
	public void add(User user) throws ClassNotFoundException , SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook" , "spring","book");
		
		PreparedStatement ps = c.prepareStatement("insert into users(id, name,password , resultSetType, resultSetConcurrency) values (?,?,?) ");
		ps.setString(1, user.getId());
		ps.setString(2,  user.getName());
		ps.setString(3 ,  user.getPassword() );
		
		ps.executeUpdate();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException , SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook" , "spring","book");
		
		PreparedStatement ps = c.prepareStatement("select * from users where id =? ");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	public static void main(String[]  args) throws ClassNotFoundException , SQLException{
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("marred");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록성공");
		
		User user2= dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() +"조회 성공");
	}
	
}
