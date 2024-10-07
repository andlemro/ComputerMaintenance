package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.IDeviceTypeService;
import com.co.cliencontrol.model.DeviceType;
import com.co.cliencontrol.repository.DeviceTypeRepository;

@Service
public class DeviceTypeServiceImpl implements IDeviceTypeService {

	@Autowired
	DeviceTypeRepository deviceTypeRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<DeviceType>> listDevicesTypes() {
		try {
			return new ResponseEntity<>(this.deviceTypeRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<DeviceType> getDeviceTypeById(Integer idDevice) {
		try {
			return new ResponseEntity<DeviceType>(this.deviceTypeRepository.findById(idDevice).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DeviceType>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<DeviceType> createDeviceType(DeviceType deviceType) {
		try {
			return new ResponseEntity<DeviceType>(this.deviceTypeRepository.save(deviceType), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DeviceType>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteDeviceTypeById(Integer IdDeviceType) {
		try {
			this.deviceTypeRepository.deleteById(IdDeviceType);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<DeviceType> uptadeDeviceType(DeviceType deviceType) {
		try {
			return new ResponseEntity<DeviceType>(this.deviceTypeRepository.save(deviceType), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DeviceType>(HttpStatus.BAD_REQUEST);
		}
	}

}
