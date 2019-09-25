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

import sef.project.management.entity.FullTimeDeveloperDetails;
import sef.project.management.service.FullTimeDeveloperService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullTimeDeveloperTest {

	private static List<FullTimeDeveloperDetails> FullTimeDeveloperDetailsList = new ArrayList<FullTimeDeveloperDetails>();

	@Autowired
	private FullTimeDeveloperService FullTimeDeveloperService;

	@BeforeClass
	public static void setFullTimeDeveloper() {
		FullTimeDeveloperDetails FullTimeDeveloper = new FullTimeDeveloperDetails();
		FullTimeDeveloper.setBlockedWeeks(15);
		FullTimeDeveloper.setSkills("java");
		FullTimeDeveloperDetailsList.add(FullTimeDeveloper);
	}

	@Test
	public void testCreateFullTimeDeveloper() {
		FullTimeDeveloperDetails FullTimeDeveloper = FullTimeDeveloperService.createFullTimeDeveloper(30, "c++");
		assertEquals(FullTimeDeveloper.getBlockedWeeks().toString(), "30");
		assertEquals(FullTimeDeveloper.getSkills().toString(), "c++");
	}

	@Test
	public void testAddFullTimeDeveloperDetails() {
		FullTimeDeveloperDetails FullTimeDeveloperDetails = new FullTimeDeveloperDetails();
		FullTimeDeveloperDetails.setBlockedWeeks(15);
		FullTimeDeveloperDetails.setSkills("java");
		List<FullTimeDeveloperDetails> FullTimeDeveloperDetailsList = FullTimeDeveloperService
				.addFullTimeDeveloper(FullTimeDeveloperTest.FullTimeDeveloperDetailsList, FullTimeDeveloperDetails);
		assertEquals(FullTimeDeveloperDetailsList.size(), 2);
	}

}