package com.co.clientcontrol.model;

import static com.co.clientcontrol.utils.DeviceTypeData.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@Tag("modelTest")
public class DeviceTypeTest {
	
	private DeviceType deviceType;

	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.deviceType = DEVICE_TYPE_MODEL_TEST;
		
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
	@DisplayName("Validation of not null fields in DeviceTypeTest model")
	void notNullFieldsTest() {
		assertAll(
			() -> assertNotNull(this.deviceType.getIdDeviceType(),
					() -> "The idDeviceType field cannot be null."),
			() -> assertNotNull(this.deviceType.getDeviceTypeName(), 
					() -> "The deviceTypeName field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of maximum length in DeviceTypeTest model")
	void validateLengthTest() {
		int deviceTypeNameLimit = 30;
		assertAll(
			() -> assertTrue(this.deviceType.getDeviceTypeName().length() < deviceTypeNameLimit,
					() -> "The deviceTypeName field exceeded the " + deviceTypeNameLimit + " character limit")
		);
	}
}
