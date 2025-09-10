package com.co.users.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@Tag("modelTest")
public class UserTest {
	
	private Rol rol;
	private User user;
	private Permission permission;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		
		this.permission = new Permission(1, "permission_access", "Acceso a modulo de permisos");
		Set<Permission> setPermissions = new HashSet<>();
		setPermissions.add(this.permission);
		
		this.rol = new Rol(1, "Operator", setPermissions);
		Set<Rol> setRoles = new HashSet<>();
		setRoles.add(this.rol);
		
		this.user = new User(1, "admin", "1234", setRoles);

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
	@DisplayName("Validation of not null in UserTest model")
	void notNullUserTest() {
		assertAll(
			() -> assertNotNull(this.user.getUsername(),
					() -> "The username field cannot be null."),
			() -> assertNotNull(this.user.getPass(),
					() -> "The pass field cannot be null."),
			() -> assertNotNull(this.user.getRoles(),
					() -> "The roles field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation of maximum length in UserTest model")
	void validateLengthTest() {
		int usernameLimit = 20;
		int passLimit = 20;
		assertAll(
			() -> assertTrue(this.user.getUsername().length() < usernameLimit,
					() -> "The username field exceeded the " + usernameLimit + " character limit"),
			() -> assertTrue(this.user.getPass().length() < passLimit,
					() -> "The pass field exceeded the " + passLimit + " character limit")
		);
	}

}
