package com.co.users.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.users.models.Rol;

public interface IRolService {

	public ResponseEntity<List<Rol>> listRoles();

	public ResponseEntity<Rol> getRolById(Integer idRol);

	public ResponseEntity<Rol> createRol(Rol rol);

	public ResponseEntity<Void> deleteRolById(Integer idRol);

	public ResponseEntity<Rol> updateRol(Rol rol);
}
