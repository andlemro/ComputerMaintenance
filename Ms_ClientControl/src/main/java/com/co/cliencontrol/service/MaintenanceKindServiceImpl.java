package com.co.cliencontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<MaintenanceKind>> listMaintenanceKinds() {
		try {
			return new ResponseEntity<>(this.maintenanceKindRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<MaintenanceKind> getMaintenanceKindById(Integer idMaintenanceKind) {
		try {
			return new ResponseEntity<>(this.maintenanceKindRepository.findById(idMaintenanceKind).get(),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<MaintenanceKind> createMaintenanceKind(MaintenanceKind maintenanceKind) {
		try {
			return new ResponseEntity<>(this.maintenanceKindRepository.save(maintenanceKind), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteMaintenanceKindById(Integer IdMaintenanceKind) {
		try {
			this.maintenanceKindRepository.deleteById(IdMaintenanceKind);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<MaintenanceKind> updateMaintenanceKind(MaintenanceKind maintenanceKind) {
		try {
			return new ResponseEntity<>(this.maintenanceKindRepository.save(maintenanceKind), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
