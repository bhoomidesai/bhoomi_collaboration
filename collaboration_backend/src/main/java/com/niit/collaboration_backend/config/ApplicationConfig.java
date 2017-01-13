package com.niit.collaboration_backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration_backend.model.*;


@Configuration
@ComponentScan("com.niit.collabration_backend")
@EnableTransactionManagement
public class ApplicationConfig 
{
	@Bean(name = "dataSource" )
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1522:orcl");
		dataSource.setUsername("bhoomi");
		dataSource.setPassword("bhoomi");
		return dataSource;
	}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto","create");
		return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory" )
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Friends.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(Bulletin.class);
		sessionBuilder.addAnnotatedClass(ChatForum.class);
		sessionBuilder.addAnnotatedClass(ChatForumComment.class);
		sessionBuilder.addAnnotatedClass(EventMaster.class);
		sessionBuilder.addAnnotatedClass(JobApplication.class);
		sessionBuilder.addAnnotatedClass(UserForum.class);
		sessionBuilder.addAnnotatedClass(UserForumComments.class);
		sessionBuilder.addAnnotatedClass(UserProfile.class);
		sessionBuilder.addAnnotatedClass(UserRole.class);
		sessionBuilder.addAnnotatedClass(UserType.class);

		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager" )
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
