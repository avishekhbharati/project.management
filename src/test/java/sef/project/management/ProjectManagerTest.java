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

import sef.project.management.dto.Activity;
import sef.project.management.entity.User;
import sef.project.management.service.ProjectManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {

	private static Activity activity;
	private static User user;

	@Autowired
	private ProjectManagerService projectManagerService;

	@BeforeClass
	public static void setValues() {
		activity = new Activity();
		activity.setActivityId(100);
		user = new User();
	}

	@Test
	public void testScheduleActivity() {
		Activity activity = projectManagerService.scheduleActivity(ProjectManagerTest.activity, new Timestamp(100),
				new Timestamp(200));
		long actualValue = activity.getStartDate().getTime();
		long expectedValue = 100;
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testDependencyAllocation() {
		Activity activity = projectManagerService.setActivityDependency(ProjectManagerTest.activity, 101);
		int expectedDpendencyId = activity.getDependencyActivityId();
		long expectedValue = 101;
		assertEquals(expectedDpendencyId, expectedValue);
	}

	@Test
	public void testUserAllocation() {
		boolean isAllocated = projectManagerService.allocateUserToActivity(ProjectManagerTest.activity,
				ProjectManagerTest.user, new Timestamp(100), new Timestamp(200));
		boolean expectedValue = true;
		assertEquals(isAllocated, expectedValue);
	}

	@Test
	public void testUserInvolvement() {
		boolean isChanged = projectManagerService.changeUserInvolvement(ProjectManagerTest.user,
				ProjectManagerTest.activity, "40");
		boolean expectedValue = true;
		assertEquals(isChanged, expectedValue);
	}

	@AfterClass
	public static void forGarbageCollection() {
		ProjectManagerTest.activity = null;
		ProjectManagerTest.user = null;
	}
}
