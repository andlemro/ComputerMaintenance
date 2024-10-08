package com.co.clientcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.clientcontrol.interfaces.IDeviceService;
import com.co.clientcontrol.model.Device;
import com.co.clientcontrol.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements IDeviceService {

	@Autowired
	DeviceRepository deviceRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<Device>> listDevices() {
		try {
			return new ResponseEntity<>(this.deviceRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Device> getDeviceById(Integer idDevice) {
		try {
			return new ResponseEntity<>(this.deviceRepository.findById(idDevice).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Device> createDevice(Device device) {
		try {
			return new ResponseEntity<Device>(this.deviceRepository.save(device), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Device>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteDeviceById(Integer IdDevice) {
		try {
			this.deviceRepository.deleteById(IdDevice);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Device> uptadeDevice(Device device) {
		try {
			return new ResponseEntity<Device>(this.deviceRepository.save(device), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Device>(HttpStatus.BAD_REQUEST);
		}
	}

}
