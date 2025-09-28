package com.co.clientcontrol.model;

import static com.co.clientcontrol.utils.MaintenanceKindData.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@Tag("modelTest")
public class MaintenanceKindTest {
	
	private MaintenanceKind maintenanceKind;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.maintenanceKind = MAINTENANCE_KIND_MODEL_TEST;
		
		testReporter.publishEntry(
				"Running: " + 
				testInfo.getDisplayName() +
				" - " +
				testInfo.getTestMethod().orElse(null).getName() +
				" with the Tag: " +
				testInfo.getTags()
		);
		
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of not null in MaintenanceKindTest model")
	void notNullMaintenanceKindTest() {
		assertAll(
			() -> assertNotNull(this.maintenanceKind.getIdMaintenanceKind(),
					() -> "The idMaintenanceKind field cannot be null."),
			() -> assertNotNull(this.maintenanceKind.getKind(), 
					() -> "The kindName field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of maximum length in MaintenanceKindTest model")
	void validateLengthTest() {
		int kindNameLimit = 30;
		assertAll(
			() -> assertTrue(this.maintenanceKind.getKind().length() < kindNameLimit,
					() -> "The deviceTypeName field exceeded the " + kindNameLimit + " character limit")
		);
	}

}
