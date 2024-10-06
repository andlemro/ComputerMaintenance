package com.co.cliencontrol.interfaces;

import java.util.List;

import com.co.cliencontrol.model.DeviceType;

public interface IDeviceTypeService {

	public List<DeviceType> listDevicesTypes();

	public DeviceType getDeviceTypeById(Integer idDevice);

	public void saveDeviceType(DeviceType deviceType);

	public void deleteDeviceTypeById(Integer IdDeviceType);

	public DeviceType uptadeDeviceType(DeviceType deviceType);
}
