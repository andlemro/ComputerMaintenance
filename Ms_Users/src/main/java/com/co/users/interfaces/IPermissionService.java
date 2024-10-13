package com.co.users.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.users.models.Permission;

public interface IPermissionService {

	public ResponseEntity<List<Permission>> listPermissions();

	public ResponseEntity<Permission> getPermissionById(Integer idPermission);

	public ResponseEntity<Permission> createPermission(Permission permission);

	public ResponseEntity<Void> deletePermissionById(Integer idPermission);

	public ResponseEntity<Permission> updatePermission(Permission permission);

}
