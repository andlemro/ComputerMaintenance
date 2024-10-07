package com.co.cliencontrol.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.cliencontrol.model.DeviceType;

public interface IDeviceTypeService {

	public ResponseEntity<List<DeviceType>> listDevicesTypes();

	public ResponseEntity<DeviceType> getDeviceTypeById(Integer idDevice);

	public ResponseEntity<DeviceType> createDeviceType(DeviceType deviceType);

	public ResponseEntity<Void> deleteDeviceTypeById(Integer IdDeviceType);

	public ResponseEntity<DeviceType> uptadeDeviceType(DeviceType deviceType);
}
