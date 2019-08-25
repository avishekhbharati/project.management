package sef.project.management;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sef.project.management.service.ProjectManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {

	@Autowired
	private ProjectManagerService projectManagerService;

	@Test
	public void sampleTest() {
		assertEquals(projectManagerService.sampleTest(), "Test");
	}
}
