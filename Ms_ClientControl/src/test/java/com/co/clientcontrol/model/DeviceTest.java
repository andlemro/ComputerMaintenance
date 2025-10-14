package com.co.clientcontrol.model;

import static com.co.clientcontrol.utils.MaintenanceKindData.*;
import static com.co.clientcontrol.utils.DeviceTypeData.*;
import static com.co.clientcontrol.utils.TradeMarkData.*;
import static com.co.clientcontrol.utils.ClientData.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.*;

@Tag("modelTest")
public class DeviceTest {
	
	private Device device;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		LocalDateTime dateTimeNow = LocalDateTime.now();
		
		this.device = new Device(1, dateTimeNow, "Se realiza cambio de pantalla", "ARS-120", CLIENT_MODEL_TEST, TRADE_MARK_MODEL_TEST, MAINTENANCE_KIND_MODEL_TEST, DEVICE_TYPE_MODEL_TEST);
		
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
	@DisplayName("Validation of not null fields in DeviceTest model")
	void notNullFieldsTest() {
		assertAll(
			// not null validations
			() -> assertNotNull(this.device.getIdDevice(),
					() -> "The idDevice field cannot be null."),
			() -> assertNotNull(this.device.getMaintenanceDate(), 
					() -> "The maintenanceDate field cannot be null."),
			() -> assertNotNull(this.device.getDescription(), 
					() -> "The description field cannot be null."),
			() -> assertNotNull(this.device.getModel(), 
					() -> "The model field cannot be null."),
			() -> assertNotNull(this.device.getIdClient(), 
					() -> "The idClient field cannot be null."),
			() -> assertNotNull(this.device.getIdTradeMark(), 
					() -> "The idTradeMark field cannot be null."),
			() -> assertNotNull(this.device.getIdMaintenanceKind(), 
					() -> "The idMaintenanceKind field cannot be null."),
			() -> assertNotNull(this.device.getIdDeviceType(), 
					() -> "The idDeviceType field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	void validateLengthTest() {
		int descriptionLimit = 200;
		int modelLimit = 30;
		
		assertAll(
			() -> assertTrue(this.device.getDescription().length() < descriptionLimit,
					() -> "The description field exceeded the " + descriptionLimit + " character limit"),
			() -> assertTrue(this.device.getModel().length() < modelLimit,
					() -> "The Model part of SubtotalCost field exceeded the " + modelLimit + " character limit")
		);
	}
	
	/**************************************************/
	
	@Test
	void validateMaintenanceDateFormatTest() {	
        LocalDateTime maintenanceDate = this.device.getMaintenanceDate().withNano(0);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        String formattedDate = maintenanceDate.format(dateFormatter);
        
        // validate format using regular expression
        String expectedPattern = "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}$";
        
		assertAll(
			() -> assertTrue(formattedDate.matches(expectedPattern),
					() -> "The date does not match the expected format dd-MM-yyyy HH:mm:ss. Result: " + formattedDate)
		);
	}
	
	/**************************************************/

}
