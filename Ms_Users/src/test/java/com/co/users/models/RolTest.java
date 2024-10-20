package com.co.users.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@Tag("modelTest")
public class RolTest {
	
	private Rol rol;
	private Permission permission;
	private TestInfo testInfo;
	private TestReporter testReporter;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
		this.permission = new Permission(1, "permission_access", "Acceso a modulo de permisos");
		Set<Permission> setPermissions = new HashSet<>();
		setPermissions.add(permission);
		
		this.rol = new Rol(1, "Operator", setPermissions);
		
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
	void notNullInvoiceTest() {
		assertAll(
			() -> assertNotNull(this.rol.getRolName(),
					() -> "The rolName field cannot be null."),
			() -> assertNotNull(this.rol.getPermissions(), 
					() -> "The permissions field cannot be null.")
		);
	}
	
	/**************************************************/
	
	@Test
	void validateLengthTest() {
		int rolNameLimit = 25;
		assertTrue(this.rol.getRolName().length() < rolNameLimit,
				() -> "The permissionName field exceeded the " + rolNameLimit + " character limit");
	}
	
}
