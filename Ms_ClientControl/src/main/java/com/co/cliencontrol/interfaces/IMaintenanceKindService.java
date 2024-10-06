package com.co.cliencontrol.interfaces;

import java.util.List;

import com.co.cliencontrol.model.MaintenanceKind;

public interface IMaintenanceKindService {

	public List<MaintenanceKind> listMaintenanceKinds();

	public MaintenanceKind getMaintenanceKindById(Integer idMaintenanceKind);

	public void saveMaintenanceKind(MaintenanceKind maintenanceKind);

	public void deleteMaintenanceKindById(Integer IdMaintenanceKind);

	public MaintenanceKind updateMaintenanceKind(MaintenanceKind maintenanceKind);

}
