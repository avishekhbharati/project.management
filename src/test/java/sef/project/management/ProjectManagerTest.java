package sef.project.management;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sef.project.management.dto.ActivityDTO;
import sef.project.management.dto.ContractorDTO;
import sef.project.management.entity.User;
import sef.project.management.service.ProjectManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {

	private static ActivityDTO activity;
	private static User user;

	@Autowired
	private ProjectManagerService projectManagerService;

	@BeforeClass
	public static void setValues() {
		activity = new ActivityDTO();
		activity.setActivityId(100);
		user = new User();
	}

	@AfterClass
	public static void forGarbageCollection() {
		ProjectManagerTest.activity = null;
		ProjectManagerTest.user = null;
	}
	
	@Test
	public void testCreateContractor() {
		Integer userId = 1;
		Integer projectId = 1;
		Integer activityId = 1;
		ActivityAllocationDTO activityAllocation = new ActivityAllocationDTO();
		projectManagerService.allocateActivity(userId, projectId, activityId, activityAllocation)
	}
}
