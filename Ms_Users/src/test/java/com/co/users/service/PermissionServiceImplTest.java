package com.co.users.service;

import static com.co.users.utils.PermissionData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.co.users.models.Permission;
import com.co.users.repository.PermissionRepository;

@ExtendWith(MockitoExtension.class)
public class PermissionServiceImplTest {

	@Mock
	PermissionRepository permissionRepository;

	@InjectMocks
	PermissionServiceImpl permissionServiceImpl;

	/**************************************************/

	@Test
	void listPermissionsTest() {
		when(this.permissionRepository.findAll()).thenReturn(PERMISSIONS_LIST);
		List<Permission> listPermissions = this.permissionServiceImpl.listPermissions().getBody();

		assertNotNull(listPermissions, () -> "The listPermissions cannot be null.");
		assertEquals(3, listPermissions.size(), () -> "The size of listPermissions is not 3.");

		verify(this.permissionRepository).findAll();
	}

	/**************************************************/
	
	@Test
	void getPermissionByIdTest() {
		when(this.permissionRepository.findById(anyInt())).thenReturn(GET_PERMISSION_ID);
		Permission permissionById = this.permissionServiceImpl.getPermissionById(anyInt()).getBody();
		
		assertNotNull(permissionById.getIdPermission());
		assertEquals(4, permissionById.getIdPermission());
		assertEquals("permission_delete", permissionById.getPermissionName());
	}
	
	/**************************************************/

	@Test
	void createPermissionTest() {
		when(this.permissionRepository.save(any(Permission.class))).thenReturn(PERMISSION);
		Permission newPermission = this.permissionServiceImpl.createPermission(PERMISSION).getBody();
		
		assertNotNull(newPermission.getIdPermission());
		assertEquals(5, newPermission.getIdPermission());
		assertEquals("permission_create_new", newPermission.getPermissionName());
		
		verify(this.permissionRepository).save(any(Permission.class));
	}
	
	/**************************************************/

	@Test
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
