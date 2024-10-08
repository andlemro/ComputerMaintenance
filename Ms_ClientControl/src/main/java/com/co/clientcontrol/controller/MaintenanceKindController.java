package com.co.clientcontrol.controller;

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

import com.co.clientcontrol.interfaces.IMaintenanceKindService;
import com.co.clientcontrol.model.MaintenanceKind;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/maintenanceKind")
public class MaintenanceKindController {

	@Autowired
	IMaintenanceKindService maintenanceKindService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<MaintenanceKind>> listMaintenanceKind() {
		return this.maintenanceKindService.listMaintenanceKinds();
	}

	/**************************************************/

	@GetMapping(value = "/{idMaintenanceKind}")
	public ResponseEntity<MaintenanceKind> getidMaintenanceKindById(
			@PathVariable("idMaintenanceKind") Integer idMaintenanceKind) {
		return this.maintenanceKindService.getMaintenanceKindById(idMaintenanceKind);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<MaintenanceKind> createMaintenanceKind(@RequestBody MaintenanceKind maintenanceKind) {
		return this.maintenanceKindService.createMaintenanceKind(maintenanceKind);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteMaintenanceKind(@PathParam("idMaintenanceKind") Integer idMaintenanceKind) {
		return this.maintenanceKindService.deleteMaintenanceKindById(idMaintenanceKind);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<MaintenanceKind> updateMaintenanceKind(@RequestBody MaintenanceKind maintenanceKind) {
		return this.maintenanceKindService.updateMaintenanceKind(maintenanceKind);
	}

}
