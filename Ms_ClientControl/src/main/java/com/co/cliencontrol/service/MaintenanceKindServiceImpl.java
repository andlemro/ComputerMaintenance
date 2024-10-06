package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.cliencontrol.interfaces.IMaintenanceKindService;
import com.co.cliencontrol.model.MaintenanceKind;
import com.co.cliencontrol.repository.MaintenanceKindRepository;

@Service
public class MaintenanceKindServiceImpl implements IMaintenanceKindService {

	@Autowired
	MaintenanceKindRepository maintenanceKindRepository;
	
	/**************************************************/
	
	@Override
	public List<MaintenanceKind> listMaintenanceKinds() {
		return this.maintenanceKindRepository.findAll();
	}
	
	/**************************************************/

	@Override
	public MaintenanceKind getMaintenanceKindById(Integer idMaintenanceKind) {
		return this.maintenanceKindRepository.findById(idMaintenanceKind).get();
	}
	
	/**************************************************/

	@Override
	public void saveMaintenanceKind(MaintenanceKind maintenanceKind) {
		this.maintenanceKindRepository.save(maintenanceKind);
	}
	
	/**************************************************/

	@Override
	public void deleteMaintenanceKindById(Integer IdMaintenanceKind) {
		this.maintenanceKindRepository.deleteById(IdMaintenanceKind);
	}
	
	/**************************************************/

	@Override
	public MaintenanceKind updateMaintenanceKind(MaintenanceKind maintenanceKind) {
		return this.maintenanceKindRepository.save(maintenanceKind);
	}

}
