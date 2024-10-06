package com.co.cliencontrol.interfaces;

import java.util.List;

import com.co.cliencontrol.model.Device;

public interface IDeviceService {

	public List<Device> listDevices();

	public Device getDeviceById(Integer idDevice);

	public void saveDevice(Device device);

	public void deleteDeviceById(Integer IdDevice);

	public Device uptadeDevice(Device device);
}
