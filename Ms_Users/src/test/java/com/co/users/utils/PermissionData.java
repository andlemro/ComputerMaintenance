package com.co.users.utils;

import java.util.List;
import java.util.Optional;

import com.co.users.models.Permission;

public class PermissionData {
	
	public final static List<Permission> PERMISSIONS_LIST = List.of(
		new Permission(1, "rol_access", "Acceso a modulo de roles"),
		new Permission(2, "permission_access", "Acceso a modulo de permisos"),
		new Permission(3, "permission_create", "Permite crear en el modulo de permisos")
	);
	
	public final static Optional<Permission> GET_PERMISSION_ID = Optional.ofNullable(new Permission(4, "get_permission_id", "Permite obtener un registro mediante el ID"));
	
	public final static Permission PERMISSION_CREATED = new Permission(5, "permission_create_new", "Permite editar un registro en el modulo de permisos");
	
	public final static Permission PERMISSION_UPDATED = new Permission(6, "permission_update", "Permite editar permisos");
}
