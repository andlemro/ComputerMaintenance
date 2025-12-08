package com.co.clientcontrol.utils;

import static com.co.clientcontrol.utils.ClientData.*;
import static com.co.clientcontrol.utils.TradeMarkData.*;
import static com.co.clientcontrol.utils.MaintenanceKindData.*;
import static com.co.clientcontrol.utils.DeviceTypeData.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.co.clientcontrol.model.Device;

public class DeviceData {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	public final static Device DEVICE_MODEL_TEST = new Device(
		1, 
		LocalDateTime.parse("11/10/2025 14:30", FORMATTER), 
		"La pantalla no da imagen", 
		"ML-10023K",
		CLIENT_MODEL_TEST,
		TRADE_MARK_MODEL_TEST,
		MAINTENANCE_KIND_MODEL_TEST,
		DEVICE_TYPE_MODEL_TEST
	);
	
	// --------------------------------------------------------
	
	public final static List<Device> DEVICES_LIST = List.of(
		new Device(
				1, 
				LocalDateTime.parse("08/09/2025 10:25", FORMATTER), 
				"Fallo en el teclado", 
				"CK-1233T",
				CLIENT_MODEL_TEST,
				TRADE_MARK_MODEL_TEST,
				MAINTENANCE_KIND_MODEL_TEST,
				DEVICE_TYPE_MODEL_TEST
			),
		new Device(
				2, 
				LocalDateTime.parse("14/09/2025 11:20", FORMATTER), 
				"La fuente de poder se quemo", 
				"MT-3105",
				CLIENT_MODEL_TEST,
				TRADE_MARK_MODEL_TEST,
				MAINTENANCE_KIND_MODEL_TEST,
				DEVICE_TYPE_MODEL_TEST
			),
		new Device(
				3, 
				LocalDateTime.parse("11/10/2025 14:30", FORMATTER), 
				"Mantinimiento preventivo", 
				"AC-M1123",
				CLIENT_MODEL_TEST,
				TRADE_MARK_MODEL_TEST,
				MAINTENANCE_KIND_MODEL_TEST,
				DEVICE_TYPE_MODEL_TEST
			)
	);
	
	// --------------------------------------------------------
		
	public final static Optional<Device> GET_DEVICE_ID = Optional.ofNullable(new Device(
		4, 
		LocalDateTime.parse("05/11/2025 16:30", FORMATTER), 
		"Revision de Torre", 
		"T120-DA",
		CLIENT_MODEL_TEST,
		TRADE_MARK_MODEL_TEST,
		MAINTENANCE_KIND_MODEL_TEST,
		DEVICE_TYPE_MODEL_TEST
	));
	
	// --------------------------------------------------------
	
	public final static Device DEVICE_CREATED = new Device(
		5, 
		LocalDateTime.parse("09/11/2025 18:20", FORMATTER), 
		"Fallo de bisagras portatil", 
		"LT-1524",
		CLIENT_MODEL_TEST,
		TRADE_MARK_MODEL_TEST,
		MAINTENANCE_KIND_MODEL_TEST,
		DEVICE_TYPE_MODEL_TEST
	);
	
	// --------------------------------------------------------
	
	public final static Device DEVICE_UPDATED = new Device(
		6, 
		LocalDateTime.parse("14/11/2025 07:40", FORMATTER), 
		"Revision General de portatil Lenovo", 
		"DA-1423T",
		CLIENT_MODEL_TEST,
		TRADE_MARK_MODEL_TEST,
		MAINTENANCE_KIND_MODEL_TEST,
		DEVICE_TYPE_MODEL_TEST
	);
	
}
