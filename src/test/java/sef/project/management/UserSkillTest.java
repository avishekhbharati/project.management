package sef.project.management;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sef.project.management.dto.SkillDTO;
import sef.project.management.dto.UserDTO;
import sef.project.management.dto.UserSkillDTO;
import sef.project.management.exception.NotFoundException;
import sef.project.management.service.ProjectManagementService;
import sef.project.management.service.SkillService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSkillTest {

	private static UserSkillDTO userSkill = new UserSkillDTO();

	@Autowired
	private SkillService skillService;

	@Autowired
	private ProjectManagementService projectManagementService;

	@BeforeClass
	public static void setValues() {
		SkillDTO skill = new SkillDTO();
		skill.setSkillId(1);
		skill.setSkillName("Python");
		userSkill.setSkill(skill);
		userSkill.setSkillLevel(10);
	}

	@Test
	public void testAddUserSkill() {
		// Add a new User to the model
		UserDTO user = new UserDTO();
		user.setId(996);
		user.setUserName("Test");
		List<UserSkillDTO> userSkills = new ArrayList<UserSkillDTO>();
		user.setUserSkills(userSkills);
		projectManagementService.getProjectMangement().getUsers().add(user);

		// Run the test case
		int initialValue = user.getUserSkills().size();
		UserDTO user2;
		try {
			user2 = skillService.addSkill(996, userSkill);
			int actualValue = user2.getUserSkills().size();
			int expectedValue = initialValue + 1;
			assertEquals(expectedValue, actualValue);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testUpdateSkillLevel() {
		// Add a new User with sills to the model
		UserDTO user = new UserDTO();
		user.setId(997);
		user.setUserName("Test");
		List<UserSkillDTO> userSkills = new ArrayList<UserSkillDTO>();
		userSkills.add(userSkill);
		user.setUserSkills(userSkills);
		projectManagementService.getProjectMangement().getUsers().add(user);

		// Run the test case
		UserDTO user2;
		try {
			user2 = skillService.updateSkillLevel(997, 12, userSkill);
			int actualValue = user2.getUserSkills().get(0).getSkillLevel();
			int expectedValue = 12;
			assertEquals(expectedValue, actualValue);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}		
	}
	@Test
	public void testAddUserSkillNeg() {
		// Add a new User to the model
		UserDTO user = new UserDTO();
		user.setId(998);
		user.setUserName("Test");
		List<UserSkillDTO> userSkills = new ArrayList<UserSkillDTO>();
		user.setUserSkills(userSkills);
		projectManagementService.getProjectMangement().getUsers().add(user);

		// Run the test case
		int initialValue = user.getUserSkills().size();
		UserDTO user2;
		try {
			// when update is not done
			user2 = skillService.addSkill(998, userSkill);
			int actualValue = user2.getUserSkills().size();
			int expectedValue = initialValue;
			assertEquals(expectedValue, actualValue);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testUpdateSkillLevelNeg() {
		// Add a new User with sills to the model
		UserDTO user = new UserDTO();
		user.setId(999);
		user.setUserName("Test");
		List<UserSkillDTO> userSkills = new ArrayList<UserSkillDTO>();
		userSkills.add(userSkill);
		user.setUserSkills(userSkills);
		projectManagementService.getProjectMangement().getUsers().add(user);

		// Run the test case
		UserDTO user2;
		try {
			// user id not found
			user2 = skillService.updateSkillLevel(1000, 12, userSkill);
			int actualValue = user2.getUserSkills().get(0).getSkillLevel();
			int expectedValue = 10;
			assertEquals(expectedValue, actualValue);	
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}	
	}
}
