package com.co.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.users.interfaces.IRolService;
import com.co.users.models.Rol;
import com.co.users.repository.RolRepository;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	RolRepository rolRepository;

	/**************************************************/

	@Override
	public ResponseEntity<List<Rol>> listRoles() {
		try {
			return new ResponseEntity<>(this.rolRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Rol> getRolById(Integer idRol) {
		try {
			return new ResponseEntity<Rol>(this.rolRepository.findById(idRol).orElseThrow(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Rol> createRol(Rol rol) {
		try {
			return new ResponseEntity<Rol>(this.rolRepository.save(rol), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Rol>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Void> deleteRolById(Integer idRol) {
		try {
			this.rolRepository.deleteById(idRol);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**************************************************/

	@Override
	public ResponseEntity<Rol> updateRol(Rol rol) {
		try {
			return new ResponseEntity<Rol>(this.rolRepository.save(rol), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Rol>(HttpStatus.BAD_REQUEST);
		}
	}

}
