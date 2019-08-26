package sef.project.management;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sef.project.management.entity.Activity;
import sef.project.management.service.ProjectManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {

	private Activity activity;
	@Autowired
	private ProjectManagerService projectManagerService;

	@Before
	public void setValues() {
		activity = new Activity();
		activity.setActivityId(100);
	}

	@Test
	public void testScheduleActivity() {
		Activity activity = projectManagerService.scheduleActivity(this.activity, new Timestamp(100),
				new Timestamp(200));
		assertEquals(activity.getStartDate().getTime(), 100);
		assertEquals(activity.getEndDate().getTime(), 200);
	}

	@Test
	public void testDependencyAllocation() {
		Activity activity = projectManagerService.setActivityDependency(this.activity, 101);
		Integer dependencyId = activity.getDependencyActivityId();
		assertEquals(Integer.parseInt(dependencyId.toString()), 101);
	}
}
