package cn.yy.blog.service;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.yy.blog.common.BaseCase;
import cn.yy.blog.dao.User;

public class UserServiceTest extends BaseCase {

	private static IUserService userService;
	
	
	@BeforeClass
	public static void setup() throws Exception{
		System.out.println(">>>setup");
        setUpBase();
        Connection conn =(Connection) dataSource.getConnection();
        userService = (IUserService) ctx.getBean("userService");
        
        //dbUtil.update(conn,"insert into B_USER (id,name,password,level,des,tel,address) values(2,'小明','e10adc3949ba59abbe56e057f20f883e',1,'我是小明','14759155555','福建');");
        //dbUtil.update(conn,"insert into B_USER (id,name,password,level,des,tel,address) values(3,'小红','e10adc3949ba59abbe56e057f20f883e',1,'我是小红','14759155555','福建福州');");
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		System.out.println(">>>tearDown");
		tearDownBase();
		if (mockDataDelete) {
			dbClean();
		}
	}
	
	@Test
	public void testGetUserDetails(){
		System.out.println(userService.getUserDetails(1));
		System.out.println("*********************************************************");
		System.out.println(userService.getUserDetails(1));
	}
	
//	@Test
//	public void testGetUserList(){
//		List<User> users = userService.getUserList(1, "小", null);
//		assertEquals(2,users.size());
//	}
	
	public static void dbClean() throws SQLException {
        
    }
	
}
