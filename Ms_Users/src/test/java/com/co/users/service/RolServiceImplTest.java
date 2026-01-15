package com.co.users.service;

import static com.co.users.utils.RolData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;	
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.users.models.Rol;
import com.co.users.repository.RolRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class RolServiceImplTest {

	@Mock
	RolRepository rolRepository;

	@InjectMocks
	RolServiceImpl rolServiceImpl;
	
	/**************************************************/
	
	@BeforeEach
	void initTest(TestInfo testInfo, TestReporter testReporter) {
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
	@DisplayName("Validation the Rol List Service in RolServiceImplTest")
	void listRolesTest() {
		
		// Given
		when(this.rolRepository.findAll()).thenReturn(ROLES_LIST);
		
		// When
		List<Rol> listRoles = this.rolServiceImpl.listRoles().getBody();

		// Then
		assertAll(
			() -> assertNotNull(listRoles, () -> "The listRoles cannot be null."),
			() -> assertEquals(2, listRoles.size(), () -> "The size of listRoles is not 2.")
		);
		
		verify(this.rolRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the Rol Get Service in RolServiceImplTest")
	void getRolByIdTest() {
		
		// Given
		when(this.rolRepository.findById(anyInt())).thenReturn(GET_ROL_ID);
		
		// When
		Rol rolById = this.rolServiceImpl.getRolById(anyInt()).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(rolById.getIdRol(), () -> "The IdRol field cannot be null."),
			() -> assertNotNull(rolById.getPermissions(), () -> "The Permissions field cannot be null."),
			() -> assertEquals(3, rolById.getIdRol(), () -> "The IdRol field is not 3."),
			() -> assertEquals("get_rol_id", rolById.getRolName(), () -> "The RolName field is not get_rol_id."),
			() -> assertEquals(1, rolById.getPermissions().size(), () -> "The size of Permissions is 1.")
		);
		
		verify(this.rolRepository).findById((anyInt()));
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation the Rol Create Service in RolServiceImplTest")
	void createRolTest() {
		
		// Given
		when(this.rolRepository.save(any(Rol.class))).thenReturn(ROL_CREATED);
		
		// When
		Rol newRol = this.rolServiceImpl.createRol(ROL_CREATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(newRol.getIdRol(), () -> "The IdRol field cannot be null."),
			() -> assertNotNull(newRol.getPermissions(), () -> "The Permissions field cannot be null."),
			() -> assertEquals(4, newRol.getIdRol(), () -> "The IdRol field is not 4."),
			() -> assertEquals("rol_create_new", newRol.getRolName(), () -> "The RolName field is not rol_create_new."),
			() -> assertEquals(1, newRol.getPermissions().size(), () -> "The size of Permissions is 1.")
		);
		
		verify(this.rolRepository).save(any(Rol.class));
	}
	
	/**************************************************/
	
	@Test
	@DisplayName("Validation the Rol Update Service in RolServiceImplTest")
	void updateRolTest() {
		
		// Given
		when(this.rolRepository.save(any(Rol.class))).thenReturn(ROL_UPDATED);
		
		// When
		Rol updatedRol = this.rolServiceImpl.updateRol(ROL_UPDATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(updatedRol.getIdRol(), () -> "The IdRol field cannot be null."),
			() -> assertNotNull(updatedRol.getPermissions(), () -> "The Permissions field cannot be null."),
			() -> assertEquals(5, updatedRol.getIdRol(), () -> "The IdRol field is not 5."),
			() -> assertEquals("rol_update", updatedRol.getRolName(), () -> "The RolName field is not rol_update."),
			() -> assertEquals(1, updatedRol.getPermissions().size(), () -> "The size of Permissions is 1.")
		);
		
		verify(this.rolRepository).save(any(Rol.class));
	}
	
	/**************************************************/
}
