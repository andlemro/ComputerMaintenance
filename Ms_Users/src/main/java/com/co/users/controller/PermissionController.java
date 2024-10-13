package com.co.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.users.interfaces.IPermissionService;
import com.co.users.models.Permission;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/permissions")
public class PermissionController {

	@Autowired
	IPermissionService permissionService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<Permission>> listPermissions() {
		return this.permissionService.listPermissions();
	}

	/**************************************************/

	@GetMapping(value = "/{idPermission}")
	public ResponseEntity<Permission> getPermisssionById(@PathVariable("idPermission") Integer idPermission) {
		return this.permissionService.getPermissionById(idPermission);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
		return this.permissionService.createPermission(permission);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deletePermissionById(@PathParam("idPermission") Integer idPermission) {
		return this.permissionService.deletePermissionById(idPermission);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<Permission> updatePermission(@RequestBody Permission permission) {
		return this.permissionService.updatePermission(permission);
	}
}
