package com.co.clientcontrol.utils;

import java.util.List;
import java.util.Optional;

import com.co.clientcontrol.model.DeviceType;

public class DeviceTypeData {

	public final static DeviceType DEVICE_TYPE_MODEL_TEST = new DeviceType(1, "Portatil");
	
	public final static List<DeviceType> DEVICE_TYPE_LIST = List.of(
			new DeviceType(1, "Portatil"),
			new DeviceType(2, "Escritorio")
		);
		
	public final static Optional<DeviceType> GET_DEVICE_TYPE_ID = Optional.ofNullable(new DeviceType(4, "Torre"));
	
	public final static DeviceType DEVICE_TYPE_CREATED = new DeviceType(5, "Todo en uno");
	
	public final static DeviceType DEVICE_TYPE_UPDATED = new DeviceType(6, "Laptop");
	
}
