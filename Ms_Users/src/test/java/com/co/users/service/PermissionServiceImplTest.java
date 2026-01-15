package com.co.users.service;

import static com.co.users.utils.PermissionData.*;
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

import com.co.users.models.Permission;
import com.co.users.repository.PermissionRepository;

@Tag("serviceImplTest")
@ExtendWith(MockitoExtension.class)
public class PermissionServiceImplTest {

	@Mock
	PermissionRepository permissionRepository;

	@InjectMocks
	PermissionServiceImpl permissionServiceImpl;
	
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
	@DisplayName("Validation the List Permission Service in PermissionServiceImplTest class")
	void listPermissionsTest() {
		
		// Given
		when(this.permissionRepository.findAll()).thenReturn(PERMISSIONS_LIST);
		
		// When
		List<Permission> listPermissions = this.permissionServiceImpl.listPermissions().getBody();

		// Then
		assertAll(
			() -> assertNotNull(listPermissions, () -> "The listPermissions cannot be null."),
			() -> assertEquals(3, listPermissions.size(), () -> "The size of listPermissions is not 3.")
		);
		
		verify(this.permissionRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the permission Get Service in PermissionServiceImplTest Class")
	void getPermissionByIdTest() {
		
		// Given
		when(this.permissionRepository.findById(anyInt())).thenReturn(GET_PERMISSION_ID);
		
		// When
		Permission permissionById = this.permissionServiceImpl.getPermissionById(anyInt()).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(permissionById.getIdPermission(), () -> "The IdPermission field cannot be null."),
			() -> assertEquals(4, permissionById.getIdPermission(), () -> "The IdPermission field is not 4."),
			() -> assertEquals("get_permission_id", permissionById.getPermissionName(), () -> "The PermissionName field is not get_permission_id.")
		);
		
		verify(this.permissionRepository).findById(anyInt());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the permission Create Service in PermissionServiceImplTest Class")
	void createPermissionTest() {
		
		// Given
		when(this.permissionRepository.save(any(Permission.class))).thenReturn(PERMISSION_CREATED);
		
		// When
		Permission newPermission = this.permissionServiceImpl.createPermission(PERMISSION_CREATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(newPermission.getIdPermission(), () -> "The IdPermission field cannot be null."),
			() -> assertEquals(5, newPermission.getIdPermission(), () -> "The IdPermission field is not 5."),
			() -> assertEquals("permission_create_new", newPermission.getPermissionName(), () -> "The PermissionName field is not permission_create_new.")
		);
		
		verify(this.permissionRepository).save(any(Permission.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the permission Update Service in PermissionServiceImplTest Class")
	void updatePermissionTest() {
		
		// Given
		when(this.permissionRepository.save(any(Permission.class))).thenReturn(PERMISSION_UPDATED);
		
		// When
		Permission updatedPermission = this.permissionServiceImpl.updatePermission(PERMISSION_UPDATED).getBody();
		
		// Then
		assertAll(
			() -> assertNotNull(updatedPermission.getIdPermission(), () -> "The IdPermission field cannot be null."),
			() -> assertEquals(6, updatedPermission.getIdPermission(), () -> "The IdPermission field is not 6."),
			() -> assertEquals("permission_update", updatedPermission.getPermissionName(), () -> "The PermissionName field is not permission_update.")
		);
		
		verify(this.permissionRepository).save(any(Permission.class));
	}
	
	/**************************************************/
	
//	@Test
//	void deletePermissionTest() {
//		doReturn(HttpStatus.OK).when(this.permissionRepository).deleteById(anyInt());
//		
//		verify(this.permissionRepository).deleteById(anyInt());
//	}

}
