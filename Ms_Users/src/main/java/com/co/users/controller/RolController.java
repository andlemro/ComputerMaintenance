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

import com.co.users.interfaces.IRolService;
import com.co.users.models.Rol;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/roles")
public class RolController {

	@Autowired
	IRolService rolService;

	/**************************************************/

	@GetMapping
	public ResponseEntity<List<Rol>> listRoles() {
		return this.rolService.listRoles();
	}

	/**************************************************/

	@GetMapping(value = "/{idRol}")
	public ResponseEntity<Rol> getRolbyId(@PathVariable("idRol") Integer IdRol) {
		return this.rolService.getRolById(IdRol);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
		return this.rolService.createRol(rol);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteRolById(@PathParam("idRol") Integer idRol) {
		return this.rolService.deleteRolById(idRol);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) {
		return this.rolService.updateRol(rol);
	}

}
