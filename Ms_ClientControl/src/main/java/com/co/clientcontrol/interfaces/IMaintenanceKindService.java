package com.co.clientcontrol.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.clientcontrol.model.MaintenanceKind;

public interface IMaintenanceKindService {

	public ResponseEntity<List<MaintenanceKind>> listMaintenanceKinds();

	public ResponseEntity<MaintenanceKind> getMaintenanceKindById(Integer idMaintenanceKind);

	public ResponseEntity<MaintenanceKind> createMaintenanceKind(MaintenanceKind maintenanceKind);

	public ResponseEntity<Void> deleteMaintenanceKindById(Integer IdMaintenanceKind);

	public ResponseEntity<MaintenanceKind> updateMaintenanceKind(MaintenanceKind maintenanceKind);

}
