package com.co.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.users.interfaces.IPermissionService;
import com.co.users.models.Permission;
import com.co.users.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<Permission>> listPermissions() {
		try {
			return new ResponseEntity<>(this.permissionRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Permission> getPermissionById(Integer idPermission) {
		try {
			return new ResponseEntity<Permission>(this.permissionRepository.findById(idPermission).get(),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Permission>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Permission> createPermission(Permission permission) {
		try {
			return new ResponseEntity<Permission>(this.permissionRepository.save(permission), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Permission>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deletePermissionById(Integer idPermission) {
		try {
			this.permissionRepository.deleteById(idPermission);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Permission> updatePermission(Permission permission) {
		try {
			return new ResponseEntity<Permission>(this.permissionRepository.save(permission), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Permission>(HttpStatus.BAD_REQUEST);
		}
	}

}
