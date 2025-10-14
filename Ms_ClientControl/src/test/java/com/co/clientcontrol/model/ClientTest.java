package com.co.clientcontrol.model;

import static com.co.clientcontrol.utils.ClientData.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@Tag("modelTest")
public class ClientTest {
	
	private Client client;
	
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.client = CLIENT_MODEL_TEST;
		
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
	@DisplayName("Validation of not null fields in the ClientTest model")
	void notNullFieldsTest() {
		assertAll(
			() -> assertNotNull(this.client.getIdClient(),
					() -> "The idClient field cannot be null."),
			() -> assertNotNull(this.client.getName(), 
					() -> "The name field cannot be null."),
			() -> assertNotNull(this.client.getLastName(), 
					() -> "The lastName field cannot be null."),
			() -> assertNotNull(this.client.getPhoneNumber(), 
					() -> "The phoneNumber field cannot be null."),
			() -> assertNotNull(this.client.getEmail(), 
					() -> "The email field cannot be null."),
			() -> assertNotNull(this.client.getAddress(), 
					() -> "The address field cannot be null."),
			() -> assertNotNull(this.client.getNeighborhood(), 
					() -> "The neighborhood field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of maximum length in the ClientTest model")
	void validateLengthTest() {
		int tradeNameLimit = 40;
		int tradeLastNameLimit = 40;
		int tradePhoneNumberLimit = 12;
		int tradeEmailLimit = 40;
		int tradeAddressLimit = 30;
		int tradeNeighborhoodLimit = 50;
		
		assertAll(
			() -> assertTrue(this.client.getName().length() < tradeNameLimit,
					() -> "The name field exceeded the " + tradeNameLimit + " character limit"),
			() -> assertTrue(this.client.getLastName().length() < tradeLastNameLimit,
					() -> "The lastName field exceeded the " + tradeLastNameLimit + " character limit"),
			() -> assertTrue(this.client.getPhoneNumber().length() < tradePhoneNumberLimit,
					() -> "The phoneNumber field exceeded the " + tradePhoneNumberLimit + " character limit"),
			() -> assertTrue(this.client.getEmail().length() < tradeEmailLimit,
					() -> "The email field exceeded the " + tradeEmailLimit + " character limit"),
			() -> assertTrue(this.client.getAddress().length() < tradeAddressLimit,
					() -> "The address field exceeded the " + tradeAddressLimit + " character limit"),
			() -> assertTrue(this.client.getNeighborhood().length() < tradeNeighborhoodLimit,
					() -> "The neighborhood field exceeded the " + tradeNeighborhoodLimit + " character limit")
		);
	}
	
	/**************************************************/
	
	private boolean isValidEmail(String email) {
		// validate format using regular expression
		String pattern = "^[\\w.+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	    return email.matches(pattern);
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of email format in the ClientTest model")
	void validateEmailFormat() {	    
	    assertAll(
	            () -> assertTrue(isValidEmail("andres@mail.com"), () -> "The format for the email is invalid."),
	            () -> assertTrue(isValidEmail("user.test+dev@mail.co"), () -> "The format for the email is invalid, it does not have .com."),
	            () -> assertFalse(isValidEmail("user@mail"), () -> "The format for the email is invalid, it does not have .com."),
	            () -> assertFalse(isValidEmail("user@@mail.com"), () -> "The format for the email is invalid, double at sign(@) is detected."),
	            () -> assertFalse(isValidEmail("@mail.com"), () -> "The format for the email is invalid. it does not own a domain.")
	        );
	    
	}
	
	/**************************************************/
}
