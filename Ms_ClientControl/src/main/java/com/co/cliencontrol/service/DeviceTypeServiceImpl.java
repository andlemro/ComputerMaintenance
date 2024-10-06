package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<DeviceType> listDevicesTypes() {
		return this.deviceTypeRepository.findAll();
	}
	
	/**************************************************/

	@Override
	public DeviceType getDeviceTypeById(Integer idDevice) {
		return this.deviceTypeRepository.findById(idDevice).get();
	}
	
	/**************************************************/

	@Override
	public void saveDeviceType(DeviceType deviceType) {
		this.deviceTypeRepository.save(deviceType);
	}
	
	/**************************************************/

	@Override
	public void deleteDeviceTypeById(Integer IdDeviceType) {
		this.deviceTypeRepository.deleteById(IdDeviceType);
	}
	
	/**************************************************/

	@Override
	public DeviceType uptadeDeviceType(DeviceType deviceType) {
		return this.deviceTypeRepository.save(deviceType);
	}

}
