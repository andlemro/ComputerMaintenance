package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.IDeviceService;
import com.co.cliencontrol.model.Device;
import com.co.cliencontrol.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements IDeviceService {

	@Autowired
	DeviceRepository deviceRepository;
	
	/**************************************************/
	
	@Override
	public List<Device> listDevices() {
		return this.deviceRepository.findAll();
	}
	
	/**************************************************/

	@Override
	public Device getDeviceById(Integer idDevice) {
		return this.deviceRepository.findById(idDevice).get();
	}
	
	/**************************************************/

	@Override
	public void saveDevice(Device device) {
		this.deviceRepository.save(device);
	}
	
	/**************************************************/

	@Override
	public void deleteDeviceById(Integer IdDevice) {
		this.deviceRepository.deleteById(IdDevice);
	}
	
	/**************************************************/

	@Override
	public Device uptadeDevice(Device device) {
		return this.deviceRepository.save(device);
	}

}
