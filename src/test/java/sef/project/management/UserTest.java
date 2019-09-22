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

import javassist.NotFoundException;
import sef.project.management.entity.User;
import sef.project.management.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	private UserService userService;
	
	private static  ArrayList<User> users ;
	
	@Before
	public void testInit() {
		users = new ArrayList<User>();		
	}
	
	@After
	public void cleanUp() {
	
	}	
	
	@Test
	public void createUserTest() {
		try {
			
			int initialCount = userService.getAllUsers().size();
			
			User u = new User();
			u.setUserName("HarryTest123");
			u.setEmail("emailtest@test.com");
			u.setRole(User.ROLE_PROJECTMANAGER);
			
			userService.addNewUser(u);			
			int finalCount = userService.getAllUsers().size();
			
			users.add(u);	//adding to delete later.

			assertEquals(initialCount + 1, finalCount, finalCount - initialCount);			
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deleteUserTest() {
		int initialCount = userService.getAllUsers().size();		
		int userDelete = 0;
		
		for (User user : users) {
			try {
				userService.deleteUser(user);
				userDelete++;
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}
		int finalCount = userService.getAllUsers().size();	
		assertEquals(initialCount - userDelete, finalCount);
	}
	
	
	
	@Test
	public void editUserTest() {	
		
		try {
			List<User> userList = userService.getAllUsers();
			
			if(userList.size() == 0) {
				User u = new User();
				u.setUserName("dummyUser123");
				u.setEmail("dummyUser123@test.com");
				u.setRole(User.ROLE_CONTRACTOR);
				
				userService.addNewUser(u);	
				userList = userService.getAllUsers();
			}
			
			User userOrg = userList.get(0);
			int id = userOrg.getId();
			String username = userOrg.getUserName();
			String email = userOrg.getEmail();
			String role = userOrg.getRole();
			
			
			//edit user
			String editedUn = "editedUsername";
			String editedEmail = "userEdited@gmail.com";			
			User editedUser = userService.editUser(id, editedUn, editedEmail, role);
			
			assertNotEquals(username, editedUser.getUserName());
			assertNotEquals(email, editedUser.getEmail());
			
			//reset
			userService.editUser(id, username, email, role);		
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
}
