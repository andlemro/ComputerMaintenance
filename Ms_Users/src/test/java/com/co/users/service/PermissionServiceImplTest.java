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

@Tag("serviceTest")
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
	@DisplayName("Validation the permission List Service in PermissionServiceImplTest")
	void listPermissionsTest() {
		when(this.permissionRepository.findAll()).thenReturn(PERMISSIONS_LIST);
		List<Permission> listPermissions = this.permissionServiceImpl.listPermissions().getBody();

		assertNotNull(listPermissions, () -> "The listPermissions cannot be null.");
		assertEquals(3, listPermissions.size(), () -> "The size of listPermissions is not 3.");

		verify(this.permissionRepository).findAll();
	}

	/**************************************************/
	
	@Test
	@DisplayName("Validation the permission Get Service in PermissionServiceImplTest")
	void getPermissionByIdTest() {
		when(this.permissionRepository.findById(anyInt())).thenReturn(GET_PERMISSION_ID);
		Permission permissionById = this.permissionServiceImpl.getPermissionById(anyInt()).getBody();
		
		assertNotNull(permissionById.getIdPermission());
		assertEquals(4, permissionById.getIdPermission());
		assertEquals("get_permission_id", permissionById.getPermissionName());
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the permission Create Service in PermissionServiceImplTest")
	void createPermissionTest() {
		when(this.permissionRepository.save(any(Permission.class))).thenReturn(PERMISSION_CREATED);
		Permission newPermission = this.permissionServiceImpl.createPermission(PERMISSION_CREATED).getBody();
		
		assertNotNull(newPermission.getIdPermission());
		assertEquals(5, newPermission.getIdPermission());
		assertEquals("permission_create_new", newPermission.getPermissionName());
		
		verify(this.permissionRepository).save(any(Permission.class));
	}
	
	/**************************************************/

	@Test
	@DisplayName("Validation the permission Update Service in PermissionServiceImplTest")
	void updatePermissionTest() {
		when(this.permissionRepository.save(any(Permission.class))).thenReturn(PERMISSION_UPDATED);
		Permission updatedPermission = this.permissionServiceImpl.updatePermission(PERMISSION_UPDATED).getBody();
		
		assertNotNull(updatedPermission.getIdPermission());
		assertEquals(6, updatedPermission.getIdPermission());
		assertEquals("permission_update", updatedPermission.getPermissionName());
		
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
