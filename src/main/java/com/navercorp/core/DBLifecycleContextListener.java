package com.navercorp.core;

import java.io.InputStreamReader;

import javax.sql.DataSource;

import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.io.DatabaseIO;
import org.apache.ddlutils.model.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBLifecycleContextListener {

	private DataSource dataSource = null;
	private ApplicationContext applicationContext = null;

	@EventListener
	public void contextInitialized(ContextStartedEvent event) {
		System.out.println("this listener started.");
		
		applicationContext = event.getApplicationContext();
		preparedDbTable();
	}

	@EventListener
	public void contextRefreshed(ContextRefreshedEvent event) {
		System.out.println("this listener refreshed.");
		
		applicationContext = event.getApplicationContext();
		preparedDbTable();
	}
	
	private void preparedDbTable() {
		
		dataSource = (DataSource) applicationContext.getBean("dataSource");

		Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
		Database database = new DatabaseIO().read(new InputStreamReader(getClass().getResourceAsStream("/ddl.xml")));

		System.out.println(database);

		platform.alterTables(database, false);
		System.out.println("HSQLDB is ready: " + platform);
	}

	@EventListener
	public void contextDestroyed(ContextClosedEvent event) {
		System.out.println("this listener closed.");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("SHUTDOWN;");
        System.out.println("Database Successfully Shutdown.");
	}
}