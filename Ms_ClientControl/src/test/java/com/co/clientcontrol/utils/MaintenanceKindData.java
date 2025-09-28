package com.co.clientcontrol.utils;

import java.util.List;
import java.util.Optional;

import com.co.clientcontrol.model.MaintenanceKind;

public class MaintenanceKindData {
	
	public final static MaintenanceKind MAINTENANCE_KIND_MODEL_TEST = new MaintenanceKind(1, "Preventivo");
	
	public final static List<MaintenanceKind> MAINTENANCE_KIND_LIST = List.of(
			new MaintenanceKind(1, "Preventivo"),
			new MaintenanceKind(2, "Correctivo")
		);
		
	public final static Optional<MaintenanceKind> GET_MAINTENANCE_KIND_ID = Optional.ofNullable(new MaintenanceKind(4, "Predictivo"));
	
	public final static MaintenanceKind MAINTENANCE_KIND_CREATED = new MaintenanceKind(5, "Proactivo");
	
	public final static MaintenanceKind MAINTENANCE_KIND_UPDATED = new MaintenanceKind(6, "Inspeccion");
	
}
