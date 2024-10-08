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

import com.co.clientcontrol.interfaces.IDeviceService;
import com.co.clientcontrol.model.Device;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	IDeviceService deviceService;

	/**************************************************/

	@GetMapping()
	public ResponseEntity<List<Device>> listDevices() {
		return this.deviceService.listDevices();
	}

	/**************************************************/

	@GetMapping(value = "/{idDevice}")
	public ResponseEntity<Device> getDeviceById(@PathVariable("idDevice") Integer idDevice) {
		return this.deviceService.getDeviceById(idDevice);
	}

	/**************************************************/

	@PostMapping(value = "/create")
	public ResponseEntity<Device> createDevice(@RequestBody Device device) {
		return this.deviceService.createDevice(device);
	}

	/**************************************************/

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteDevice(@PathParam("idDevice") Integer idDevice) {
		return this.deviceService.deleteDeviceById(idDevice);
	}

	/**************************************************/

	@PutMapping(value = "/update")
	public ResponseEntity<Device> updateDevice(@RequestBody Device device) {
		return this.deviceService.uptadeDevice(device);
	}
}
