package sef.project.management;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sef.project.management.entity.User;
import sef.project.management.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService userService;
	
	private static  ArrayList<User> users ;
	
	@Before
	public static void testInit() {
		users = new ArrayList<User>();		
	}
	
	@After
	public static void cleanUp() {
	
	}	
	
	@Test
	public void createUserTest() {
		userService.addUser("HarryTest123", "emailtest@test.com", User.ROLE_PROJECTMANAGER);
		userService.addUser("BobTest123", "emailtest@test.com", User.ROLE_EMPLOYEE);		
		int count = userService.getUsersCount();
		assertEquals(2 , count);			
	}
	
	
	@Test
	public void deleteUserTest() {
		User u = new User();
		u.setEmail("xyz@email");
		u.setUserName("un");
		u.setRole(User.ROLE_PROJECTMANAGER);		
		userService.addUser(u);
		int count1 = userService.getUsersCount();					
		userService.removeUser(u);		
		int count2 = userService.getUsersCount();
		assertEquals(count1-1, count2);		
	}
}
