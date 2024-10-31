package com.co.users.utils;

import java.util.List;

import com.co.users.models.Permission;

public class PermissionData {

	public final static List<Permission> PERMISSIONS_LIST = List.of(
		new Permission(1, "rol_access", "Acceso a modulo de roles"),
		new Permission(2, "permission_access", "Acceso a modulo de permisos"),
		new Permission(3, "permission_create", "Permite crear en el modulo de permisos")
	);
	
	public final static Permission PERMISSION = new Permission(4, "permission_delete", "Permite eliminar un registro en el modulo de permisos");
}
