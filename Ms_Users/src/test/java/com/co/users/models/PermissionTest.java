package com.co.users.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@Tag("modelTest")
public class PermissionTest {
	
	private Permission permission;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.permission = new Permission(1, "permission_access", "Acceso a modulo de permisos");
		
		testReporter.publishEntry(
				"Running: " + 
				testInfo.getDisplayName() +
				" - " +
				testInfo.getTestMethod().orElse(null) +
				" with the Tag: " +
				testInfo.getTags()
		);
		
	}
	
	/**************************************************/
	
	@Test
	void notNullPermissionTest() {
		assertAll(
			() -> assertNotNull(this.permission.getPermissionName(),
					() -> "The permissionName field cannot be null."),
			() -> assertNotNull(this.permission.getDescription(), 
					() -> "The description field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	void validateLengthTest() {
		int permissionNameLimit = 25;
		int descriptionLimit = 40;
		assertAll(
			() -> assertTrue(this.permission.getPermissionName().length() < permissionNameLimit,
					() -> "The permissionName field exceeded the " + permissionNameLimit + " character limit"),
			() -> assertTrue(this.permission.getDescription().length() < descriptionLimit,
					() -> "The description field exceeded the " + descriptionLimit + " character limit")
		);
	}
	
}
