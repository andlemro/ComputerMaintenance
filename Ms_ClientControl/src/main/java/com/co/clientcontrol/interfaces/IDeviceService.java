package com.co.clientcontrol.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.clientcontrol.model.Device;

public interface IDeviceService {

	public ResponseEntity<List<Device>> listDevices();

	public ResponseEntity<Device> getDeviceById(Integer idDevice);

	public ResponseEntity<Device> createDevice(Device device);

	public ResponseEntity<Void> deleteDeviceById(Integer IdDevice);

	public ResponseEntity<Device> uptadeDevice(Device device);
}
