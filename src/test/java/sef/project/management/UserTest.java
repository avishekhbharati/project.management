package sef.project.management;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sef.project.management.constants.Constants;
import sef.project.management.dto.UserDTO;
import sef.project.management.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	//@Autowired
	//private ProjectManagementService pms;

	@Autowired
	private UserService userService;
	
    private static ArrayList<UserDTO> users;

	@Before
	public void testInit() {
		users = new ArrayList<UserDTO>();
	}

	@After
	public  void cleanUp() {
		
	}

	@Test
	public void createUserTest() {
		int initialCount = userService.getAllUsers().size();

		UserDTO u = new UserDTO();
		u.setId(1);
		u.setUserName("UnTest1");
		u.setEmail("emailtest1@test.com");
		u.setRole(Constants.ROLE_PROJECT_MANAGER);

		userService.addNewUser(u);

		int finalCount = userService.getAllUsers().size();
		assertEquals(initialCount + 1, finalCount, finalCount - initialCount);
	}

	
	@Test
	public void deleteUserTest() {
		
		//first add
		UserDTO u = new UserDTO();
		u.setId(2);
		u.setUserName("UnTest2");
		u.setEmail("emailtest2@test.com");
		u.setRole(Constants.ROLE_PROJECT_MANAGER);
		userService.addNewUser(u);
				
		//check count
		int expected = userService.getAllUsers().size();

		userService.deleteUser(2);
		int actual = userService.getAllUsers().size();
		
		assertEquals(expected-1, actual);	
	}
	
	@Test
	public void createUserTestNeg() { 
		int initialCount = userService.getAllUsers().size();

		UserDTO u = new UserDTO();
		u.setId(3);
		u.setUserName("UnTest11");
		u.setEmail("emailtest11@test.com");
		u.setRole(Constants.ROLE_PROJECT_MANAGER);

		userService.addNewUser(u);
				
		UserDTO u2 = new UserDTO();
		u2.setId(4);
		u2.setUserName("UnTest12");
		u2.setEmail("emailtest11@test.com");
		u2.setRole(Constants.ROLE_PROJECT_MANAGER);

		String response = userService.addNewUser(u2);
		
		assertEquals("Expected value didn't match the actual value.", "User added.", response);
		
	}
	
	@Test
	public void deleteUserTestNeg() {		
		//first add
		UserDTO u = new UserDTO();
		u.setId(5);
		u.setUserName("InvalidUser");
		u.setEmail("InvalidUser@test.com");
		u.setRole(Constants.ROLE_PROJECT_MANAGER);			
		userService.addNewUser(u);
		
		String response = userService.deleteUser(5);		
		System.out.println(response);
		assertEquals("User deleted.", response);		
	}
	
}
