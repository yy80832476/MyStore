package cn.yy.blog.common;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class BaseCase {
	
	protected static boolean mockDataDelete = false;//是否删除模拟数据

	protected static ApplicationContext ctx = null;
	protected static DataSource dataSource;
	
	/**
	 * dbUtil使用请参考:
	 * http://commons.apache.org/proper/commons-dbutils/examples.html
	 */
	protected static QueryRunner dbUtil = null;
	
	
	protected static void setUpBase() throws Exception {
		System.out.println(">>>setUpBase");
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		Log4jConfigurer.initLogging("classpath:resources/log4j.properties");
		ctx = new ClassPathXmlApplicationContext("/resources/spring.xml", "/resources/spring-mybatis.xml");  
		dataSource=(DataSource)ctx.getBean("dataSource");
		dbUtil = new QueryRunner(dataSource);
	}
	
	protected static void tearDownBase() throws Exception{
		System.out.println(">>>tearDownBase");
	}
	
}
