package com.co.users.utils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.co.users.models.Permission;
import com.co.users.models.Rol;

public class RolData {
	
	public final static Set<Permission> PERMISSIONS_USER = Set.of(
			new Permission(1, "system_access", "Acceso al sistema")
		);
	
	public final static Set<Permission> PERMISSIONS_ADMIN = Set.of(
			new Permission(1, "system_access", "Acceso al sistema"),
			new Permission(2, "", "Acceso a modulo de permisos")
		);

	public final static List<Rol> ROLES_LIST = List.of(
			new Rol(1, "User", PERMISSIONS_USER),
			new Rol(2, "Admin", PERMISSIONS_ADMIN)
		);
	
	public final static Optional<Rol> GET_ROL_ID = Optional.ofNullable(
			new Rol(3, "get_rol_id", Set.of(new Permission(3, "system_access", "Acceso al sistema")))
	);	
	
	public final static Rol ROL_CREATED = new Rol(4, "rol_create_new", Set.of(new Permission(3, "system_access", "Acceso al sistema")));
	
	public final static Rol ROL_UPDATED = new Rol(5, "rol_update", Set.of(new Permission(3, "system_access", "Acceso al sistema")));
	
}
