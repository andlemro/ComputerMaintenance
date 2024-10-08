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

import com.co.clientcontrol.interfaces.IDeviceTypeService;
import com.co.clientcontrol.model.DeviceType;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/deviceType")
public class DeviceTypeController {

	@Autowired
	IDeviceTypeService deviceTypeService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<DeviceType>> listDeviceTypes() {
		return this.deviceTypeService.listDevicesTypes();
	}

	/**************************************************/

	@GetMapping(value = "/{idDeviceType}")
	public ResponseEntity<DeviceType> getDeviceTypeById(@PathVariable("idDeviceType") Integer IdDeviceType) {
		return this.deviceTypeService.getDeviceTypeById(IdDeviceType);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<DeviceType> createDeviceType(@RequestBody DeviceType deviceType) {
		return this.deviceTypeService.createDeviceType(deviceType);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteDeviceType(@PathParam("idDeviceType") Integer idDeviceType) {
		return this.deviceTypeService.deleteDeviceTypeById(idDeviceType);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<DeviceType> updateDeviceType(@RequestBody DeviceType deviceType) {
		return this.deviceTypeService.uptadeDeviceType(deviceType);
	}

}
