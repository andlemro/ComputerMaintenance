package com.co.users.utils;

import static com.co.users.utils.RolData.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.co.users.models.Rol;
import com.co.users.models.User;

public class UserData {

	public final static List<User> USERS_LIST = List.of(
			new User(1, "User_test", "123", Set.of(new Rol(1, "User", PERMISSIONS_USER))),
			new User(2, "Admin_test", "12345", Set.of(new Rol(2, "Admin", PERMISSIONS_ADMIN)))
		);
	
	public final static Optional<User> GET_USER_ID = Optional.ofNullable(
			new User(3, "get_user_id", "4321", Set.of(new Rol(2, "Admin", PERMISSIONS_ADMIN)))
	);	
	
	public final static User USER_CREATED = new User(4, "user_create_new", "6543", Set.of(new Rol(1, "User", PERMISSIONS_USER)));
	
	public final static User USER_UPDATED = new User(5, "user_update", "0987" ,Set.of(new Rol(2, "Admin", PERMISSIONS_ADMIN)));
	
}
