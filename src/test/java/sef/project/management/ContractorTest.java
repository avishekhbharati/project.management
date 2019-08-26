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

import sef.project.management.entity.ContractorDetails;
import sef.project.management.service.ContractorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractorTest {

	private static List<ContractorDetails> contractorDetailsList = new ArrayList<ContractorDetails>();

	@Autowired
	private ContractorService contractorService;

	@BeforeClass
	public static void setContractor() {
		ContractorDetails contractor = new ContractorDetails();
		contractor.setRate(30);
		contractor.setWeeks(2);
		contractorDetailsList.add(contractor);
	}

	@Test
	public void testCreateContractor() {
		ContractorDetails contractor = contractorService.createContractor(1, 20);
		assertEquals(contractor.getRate().toString(), "20");
		assertEquals(contractor.getWeeks().toString(), "1");
	}

	@Test
	public void testAddContractorDetails() {
		ContractorDetails contractorDetails = new ContractorDetails();
		contractorDetails.setRate(30);
		contractorDetails.setWeeks(2);
		List<ContractorDetails> contractorDetailsList = contractorService
				.addContractor(ContractorTest.contractorDetailsList, contractorDetails);
		assertEquals(contractorDetailsList.size(), 2);
	}

}
