package com.co.users.service;

import static com.co.users.utils.PermissionData.PERMISSION;
import static com.co.users.utils.PermissionData.PERMISSIONS_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	void createPermissionTest() {
		when(this.permissionRepository.save(any(Permission.class))).thenReturn(PERMISSION);
		Permission newPermission = this.permissionServiceImpl.createPermission(PERMISSION).getBody();
		
		assertNotNull(newPermission.getIdPermission());
		assertEquals(4, newPermission.getIdPermission());
		assertEquals("permission_delete", newPermission.getPermissionName());
		
		verify(this.permissionRepository).save(any(Permission.class));
	}

}
